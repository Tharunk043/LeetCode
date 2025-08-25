class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxwords = 0;
        for(String sentence:sentences){
            String[] words = sentence.split(" ");
            maxwords = Math.max(maxwords,words.length);
        }
        return maxwords;

    }
}