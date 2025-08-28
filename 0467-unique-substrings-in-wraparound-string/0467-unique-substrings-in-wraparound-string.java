class Solution {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[26]; // dp[i] = max length of valid substring ending with 'a'+i
        int maxLenCur = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 ||
                         (s.charAt(i - 1) == 'z' && s.charAt(i) == 'a'))) {
                maxLenCur++;
            } else {
                maxLenCur = 1;
            }

            int idx = s.charAt(i) - 'a';
            dp[idx] = Math.max(dp[idx], maxLenCur);
        }

        int result = 0;
        for (int val : dp) result += val;
        return result;
    }
}
