class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        
        // Case 1: all uppercase
        if (word.equals(word.toUpperCase())) return true;
        
        // Case 2: all lowercase
        if (word.equals(word.toLowerCase())) return true;
        
        // Case 3: First letter uppercase, rest lowercase
        if (Character.isUpperCase(word.charAt(0)) && 
            word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }
        
        return false;
    }
}
