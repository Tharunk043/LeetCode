class Solution {
    public boolean checkZeroOnes(String s) {
        int max1 = 0, max0 = 0;
        int curr1 = 0, curr0 = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                curr1++;
                curr0 = 0;
                max1 = Math.max(max1, curr1);
            } else {
                curr0++;
                curr1 = 0;
                max0 = Math.max(max0, curr0);
            }
        }

        return max1 > max0;
    }
}
