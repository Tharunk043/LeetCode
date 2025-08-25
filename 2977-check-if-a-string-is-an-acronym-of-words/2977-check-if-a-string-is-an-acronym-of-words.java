class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String interstr = "";
        for(String word:words){
            interstr+=word.charAt(0);
        }
        return interstr.equals(s);
    }
}