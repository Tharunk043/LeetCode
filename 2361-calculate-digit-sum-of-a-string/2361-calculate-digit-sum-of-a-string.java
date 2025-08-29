class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder newS = new StringBuilder();
            
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                // take substring of length k (or less if at end)
                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    sum += s.charAt(j) - '0';
                }
                newS.append(sum);
            }
            
            s = newS.toString();
        }
        return s;
    }
}
