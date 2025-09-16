class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a','e','i','o','u','A','I','O','U','E');
        int left = 0;
        int right = s.length()-1;
        char ch[] = s.toCharArray();
        while(left<right){
            if(!vowels.contains(ch[left]))left++;
            else if(!vowels.contains(ch[right])) right--;
            else{
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