class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue; // skip unused chars

            freq[i]--; // remove one occurrence

            if (check(freq)) return true;

            freq[i]++; // restore
        }

        return false;
    }

    private boolean check(int[] freq) {
        int common = 0;
        for (int f : freq) {
            if (f == 0) continue;
            if (common == 0) common = f;
            else if (f != common) return false;
        }
        return true;
    }
}
