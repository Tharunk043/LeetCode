class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] ch = new int[26];
        for(char c:sentence.toCharArray()){
            ch[c-'a'] = 1;
        }
        for(int c:ch){
            if(c!=1) return false;
        }
        return true;
    }
}