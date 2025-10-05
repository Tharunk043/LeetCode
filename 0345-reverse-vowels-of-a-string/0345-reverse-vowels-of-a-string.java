class Solution {
    public String reverseVowels(String s) {
        List vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        int left =  0;
        int right = s.length()-1;
        char [] ch = s.toCharArray();
        while(left<right){
            while(left<right && !vowels.contains(ch[left]))left++;
            while(left<right && !vowels.contains(ch[right])) right--;
            if(left<right){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        return new String(ch);

    }
}