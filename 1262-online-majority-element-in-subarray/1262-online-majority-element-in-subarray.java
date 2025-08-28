import java.util.*;

class MajorityChecker {
    private int[] arr;
    private Map<Integer, List<Integer>> posMap;
    private int[] segTree;  // stores candidate element

    public MajorityChecker(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        segTree = new int[4 * n];
        posMap = new HashMap<>();

        // Build position map
        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        build(1, 0, n - 1);
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            segTree[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        int leftCandidate = segTree[node * 2];
        int rightCandidate = segTree[node * 2 + 1];
        segTree[node] = merge(leftCandidate, rightCandidate, l, r);
    }

    private int merge(int a, int b, int l, int r) {
        if (a == b) return a;
        int mid = (l + r) / 2;
        if (a != 0 && countInRange(a, l, r) > (r - l + 1) / 2) return a;
        if (b != 0 && countInRange(b, l, r) > (r - l + 1) / 2) return b;
        return 0;
    }

    private int querySeg(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return segTree[node];
        int mid = (l + r) / 2;
        int leftCand = querySeg(node * 2, l, mid, ql, qr);
        int rightCand = querySeg(node * 2 + 1, mid + 1, r, ql, qr);
        if (leftCand == 0) return rightCand;
        if (rightCand == 0) return leftCand;
        return (countInRange(leftCand, ql, qr) >= countInRange(rightCand, ql, qr))
            ? leftCand : rightCand;
    }

    private int countInRange(int x, int l, int r) {
        List<Integer> list = posMap.get(x);
        if (list == null) return 0;
        int left = lowerBound(list, l);
        int right = upperBound(list, r);
        return right - left;
    }

    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public int query(int left, int right, int threshold) {
        int cand = querySeg(1, 0, arr.length - 1, left, right);
        if (cand == 0) return -1;
        int freq = countInRange(cand, left, right);
        return freq >= threshold ? cand : -1;
    }
}
