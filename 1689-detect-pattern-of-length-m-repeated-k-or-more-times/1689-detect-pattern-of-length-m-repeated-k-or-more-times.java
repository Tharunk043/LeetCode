class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        
        for (int i = 0; i + m * k <= n; i++) {
            boolean valid = true;
            for (int j = i + m; j < i + m * k; j++) {
                if (arr[j] != arr[j - m]) {
                    valid = false;
                    break;
                }
            }
            if (valid) return true;
        }
        
        return false;
    }
}
