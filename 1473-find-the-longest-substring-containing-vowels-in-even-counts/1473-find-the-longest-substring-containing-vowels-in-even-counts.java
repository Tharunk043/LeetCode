class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> seen = new HashMap<>();
        int mask = 0, res = 0;
        seen.put(0, -1); // base case: mask=0 before start

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a') mask ^= (1 << 0);
            else if (c == 'e') mask ^= (1 << 1);
            else if (c == 'i') mask ^= (1 << 2);
            else if (c == 'o') mask ^= (1 << 3);
            else if (c == 'u') mask ^= (1 << 4);

            if (seen.containsKey(mask)) {
                res = Math.max(res, i - seen.get(mask));
            } else {
                seen.put(mask, i); // store first occurrence
            }
        }
        return res;
    }
}
