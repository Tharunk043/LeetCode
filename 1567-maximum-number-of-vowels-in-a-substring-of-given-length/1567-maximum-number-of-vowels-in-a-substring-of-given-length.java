class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        int windowv =0;
        int maxv =0;
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i = 0;i<k;i++){
            if(vowels.contains(s.charAt(i))) windowv++;
        }
        maxv = windowv;
        for(int i = k;i<s.length();i++){
            if(vowels.contains(s.charAt(i-k)) ) windowv--;
            if(vowels.contains(s.charAt(i))) windowv++;
            maxv = Math.max(windowv,maxv);
            if(maxv==k) break;
        }
        return maxv;

    }
}