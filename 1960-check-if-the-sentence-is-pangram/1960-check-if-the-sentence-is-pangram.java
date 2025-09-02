class Solution {
    public boolean checkIfPangram(String sentence) {
        char[] ch = new char[26];
        for(char c:sentence.toCharArray()){
            ch[c-'a'] = 1;
        }
        for(char c:ch){
            if(c!=1) return false;
        }
        return true;
    }
}