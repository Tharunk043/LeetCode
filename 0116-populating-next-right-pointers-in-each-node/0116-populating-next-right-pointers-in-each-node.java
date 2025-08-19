/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node leftMost = root;
        while (leftMost.left != null) {  // since perfect binary tree
            Node head = leftMost;
            while (head != null) {
                // connect left → right
                head.left.next = head.right;
                
                // connect right → next.left
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                head = head.next;  // move horizontally
            }
            leftMost = leftMost.left; // go down one level
        }
        
        return root;
    }
}
