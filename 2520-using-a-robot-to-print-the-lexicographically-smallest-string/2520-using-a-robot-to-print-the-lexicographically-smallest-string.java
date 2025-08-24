class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minSuffix = new char[n];
        
        // Precompute min suffix characters
        minSuffix[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }
        
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));
            // While we can safely pop from stack
            while (!stack.isEmpty() && (i == n - 1 || stack.peek() <= minSuffix[i + 1])) {
                res.append(stack.pop());
            }
        }
        
        return res.toString();
    }
}
