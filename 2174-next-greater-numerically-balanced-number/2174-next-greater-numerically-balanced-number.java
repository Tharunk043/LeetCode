class Solution {
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBeautiful(num)) {
                return num;
            }
            num++;
        }
    }

    private boolean isBeautiful(int num) {
        int[] count = new int[10]; // for digits 0–9
        String s = String.valueOf(num);

        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }

        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (count[digit] != digit) return false;
        }
        return true;
    }
}
