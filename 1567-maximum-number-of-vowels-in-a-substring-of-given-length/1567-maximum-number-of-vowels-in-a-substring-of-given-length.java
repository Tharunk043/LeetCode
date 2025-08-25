class Solution {
    public int maxVowels(String s, int k) {
        int maxv = 0;
        int windv =0;
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('i');
        vowels.add('o');
        vowels.add('e');
        vowels.add('u');
        for(int i = 0 ;i<k;i++){
            if(vowels.contains(s.charAt(i))) windv ++;
        }
        maxv= windv;
        for(int i = k;i<s.length();i++){
            if(vowels.contains(s.charAt(i-k))) windv--;
            if(vowels.contains(s.charAt(i))) windv++;
            maxv = Math.max(maxv,windv);
        } 
        return maxv;

    }
}