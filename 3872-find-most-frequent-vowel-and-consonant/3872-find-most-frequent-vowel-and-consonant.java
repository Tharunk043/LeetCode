class Solution {
    public int maxFreqSum(String s) {
        int[] vowelFreq = new int[26];
        int[] consFreq  = new int[26];

        for (char ch : s.toCharArray()) {
            if (!Character.isLetter(ch)) continue;
            char c = Character.toLowerCase(ch);
            if (isVowel(c)) vowelFreq[c - 'a']++;
            else            consFreq[c - 'a']++;
        }

        int maxV = 0, maxC = 0;
        for (int i = 0; i < 26; i++) {
            if (vowelFreq[i] > maxV) maxV = vowelFreq[i];
            if (consFreq[i]  > maxC) maxC = consFreq[i];
        }
        return maxV + maxC;
    }

    private boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
