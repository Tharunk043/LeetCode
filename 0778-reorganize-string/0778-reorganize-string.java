class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for(char c:s.toCharArray()){
            hash[c-'a']++;
        }
        int maxfreq = 0;int letter = 0;
        for(int i =0;i<hash.length;i++){
            if(hash[i]>maxfreq){
                maxfreq = hash[i];
                letter = i;
            }
        }
        if(maxfreq>(s.length()+1)/2) return "";
        char[] res = new char[s.length()];
        int idx = 0;
        while(hash[letter]-->0){
            res[idx] = (char)(letter+'a');
            idx+=2;
        }
        for(int i = 0;i<hash.length;i++){
            while(hash[i]-->0){
                if(idx>=res.length)idx = 1;
                res[idx] = (char)(i+'a');
                idx+=2;
            }
        }
        return String.valueOf(res);

    }
}