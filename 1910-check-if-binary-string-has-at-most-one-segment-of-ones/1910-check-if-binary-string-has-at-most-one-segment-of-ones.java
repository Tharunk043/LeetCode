class Solution {
    public boolean checkOnesSegment(String s) {
        // A binary string has at most one segment of 1s 
        // if it does not contain "01" followed by another '1'
        return !s.contains("01");
    }
}

