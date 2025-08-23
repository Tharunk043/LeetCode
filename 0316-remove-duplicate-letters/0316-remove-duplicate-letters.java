import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] inStack = new boolean[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            
            if (inStack[c - 'a']) continue;
            
            while (!stack.isEmpty() && stack.peekLast() > c && freq[stack.peekLast() - 'a'] > 0) {
                inStack[stack.pollLast() - 'a'] = false;
            }
            
            stack.addLast(c);
            inStack[c - 'a'] = true;
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : stack) result.append(c);
        
        return result.toString();
    }
}
