class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] freq = new int[26];  // for 'a' to 'z'

        // count characters in word1
        for (char c : word1.toCharArray()) {
            freq[c - 'a']++;
        }

        // subtract counts for word2
        for (char c : word2.toCharArray()) {
            freq[c - 'a']--;
        }

        // check absolute difference
        for (int count : freq) {
            if (Math.abs(count) > 3) {
                return false;
            }
        }

        return true;
    }
}
