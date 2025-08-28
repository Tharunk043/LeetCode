class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i + 1);
            char c3 = num.charAt(i + 2);

            if (c1 == c2 && c2 == c3) {
                String candidate = num.substring(i, i + 3);
                if (res.equals("") || candidate.compareTo(res) > 0) {
                    res = candidate;
                }
            }
        }
        return res;
    }
}
