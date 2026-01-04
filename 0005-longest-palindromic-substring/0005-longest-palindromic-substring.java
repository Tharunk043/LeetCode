class Solution {
    public String longestPalindrome(String s) {
       String longest = "";
       for(int i = 0;i<s.length();i++){
        String even = expand(s,i,i);
       String odd = expand(s,i,i+1);
        String curr = even.length()>odd.length()?even:odd;
       longest = curr.length()>longest.length()?curr:longest;
       } 
       return longest;
    }
    String expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}