class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // remove first and last character
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }
}
