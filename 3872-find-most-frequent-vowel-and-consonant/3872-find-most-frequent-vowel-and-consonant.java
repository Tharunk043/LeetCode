class Solution {
    public int maxFreqSum(String s) {
        int [] freq= new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int vmax = 0;
        int cmax = 0;
        for(char c:s.toCharArray()){
            if("aeiou".indexOf(c)!=-1){
                vmax = Math.max(vmax,freq[c-'a']);
            }else{
                cmax = Math.max(cmax,freq[c-'a']);
            }
        }
        return vmax+cmax;
    }
}