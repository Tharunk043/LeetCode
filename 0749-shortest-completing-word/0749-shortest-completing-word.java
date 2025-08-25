class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] targetCount = getCharCount(licensePlate);
        String result = null;

        for (String word : words) {
            int[] wordCount = getCharCount(word);

            if (isCompleting(wordCount, targetCount)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }

    private int[] getCharCount(String str) {
        int[] count = new int[26]; // only letters
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                count[Character.toLowerCase(c) - 'a']++;
            }
        }
        return count;
    }

    private boolean isCompleting(int[] wordCount, int[] targetCount) {
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] < targetCount[i]) {
                return false;
            }
        }
        return true;
    }
}
