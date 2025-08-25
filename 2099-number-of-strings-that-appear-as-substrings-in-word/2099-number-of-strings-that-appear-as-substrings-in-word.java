class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int times = 0;
        for(String str:patterns){
            if(word.contains(str)) times++;
        }
        return times;
    }
}