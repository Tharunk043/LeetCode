class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        
        for (int i = 1; i < arr.length; i += 2) {
            // arr[i] is a digit → shift previous character
            int shift = arr[i] - '0'; 
            arr[i] = (char)(arr[i - 1] + shift);
        }
        
        return new String(arr);
    }
}
