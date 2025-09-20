import java.util.*;

public class Router {
    private int memoryLimit;
    private Deque<int[]> queue;
    private Set<String> seen;
    private Map<Integer, Node> roots;
    private Random rand = new Random();

    private static class Node {
        int key;       // timestamp
        int val;       // count at this timestamp
        int sum;       // subtree sum
        int priority;
        Node left, right;
        Node(int key, int val, int priority) {
            this.key = key; this.val = val; this.sum = val; this.priority = priority;
        }
    }

    private int getSum(Node n) { return n == null ? 0 : n.sum; }
    private void pull(Node n) { if (n != null) n.sum = n.val + getSum(n.left) + getSum(n.right); }

    private Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        pull(y);
        pull(x);
        return x;
    }
    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        pull(x);
        pull(y);
        return y;
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.priority < right.priority) {
            left.right = merge(left.right, right);
            pull(left);
            return left;
        } else {
            right.left = merge(left, right.left);
            pull(right);
            return right;
        }
    }

    // insert delta at key (delta can be +1 or -1). If resulting val==0, node is removed.
    private Node insert(Node root, int key, int delta) {
        if (root == null) {
            if (delta <= 0) return null;
            return new Node(key, delta, rand.nextInt());
        }
        if (key == root.key) {
            root.val += delta;
            if (root.val <= 0) {
                return merge(root.left, root.right);
            } else {
                pull(root);
                return root;
            }
        } else if (key < root.key) {
            root.left = insert(root.left, key, delta);
            if (root.left != null && root.left.priority < root.priority) root = rotateRight(root);
        } else {
            root.right = insert(root.right, key, delta);
            if (root.right != null && root.right.priority < root.priority) root = rotateLeft(root);
        }
        pull(root);
        return root;
    }

    // sum of values with key <= given key
    private int sumLE(Node root, int key) {
        if (root == null) return 0;
        if (root.key <= key) {
            return getSum(root.left) + root.val + sumLE(root.right, key);
        } else {
            return sumLE(root.left, key);
        }
    }

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.roots = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) return false;

        // evict oldest if full
        if (queue.size() == memoryLimit) {
            int[] old = queue.pollFirst();
            String oldKey = old[0] + "#" + old[1] + "#" + old[2];
            seen.remove(oldKey);
            Node rootOld = roots.get(old[1]);
            rootOld = insert(rootOld, old[2], -1);
            if (rootOld == null) roots.remove(old[1]); else roots.put(old[1], rootOld);
        }

        queue.offerLast(new int[]{source, destination, timestamp});
        seen.add(key);

        Node root = roots.get(destination);
        root = insert(root, timestamp, +1);
        if (root == null) roots.remove(destination); else roots.put(destination, root);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};
        int[] p = queue.pollFirst();
        String key = p[0] + "#" + p[1] + "#" + p[2];
        seen.remove(key);
        Node root = roots.get(p[1]);
        root = insert(root, p[2], -1);
        if (root == null) roots.remove(p[1]); else roots.put(p[1], root);
        return p;
    }

    public int getCount(int destination, int startTime, int endTime) {
        Node root = roots.get(destination);
        if (root == null) return 0;
        int upToEnd = sumLE(root, endTime);
        int beforeStart = sumLE(root, startTime - 1);
        return upToEnd - beforeStart;
    }
}
