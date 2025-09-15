class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        String[] words = text.split(" ");

        for (String word : words) {
            boolean cantype = true;
            for (char c : brokenLetters.toCharArray()) {
                if (word.indexOf(c) != -1) { // word contains a broken letter
                    cantype = false;
                    break;
                }
            }
            if (cantype) count++;
        }

        return count;
    }
}
