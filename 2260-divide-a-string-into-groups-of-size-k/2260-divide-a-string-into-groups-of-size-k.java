class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i += k) {
            if (i + k <= s.length()) {
                // take full chunk
                res.add(s.substring(i, i + k));
            } else {
                // take remaining and fill
                StringBuilder sb = new StringBuilder(s.substring(i));
                while (sb.length() < k) {
                    sb.append(fill);
                }
                res.add(sb.toString());
            }
        }
        
        return res.toArray(new String[0]);
    }
}
