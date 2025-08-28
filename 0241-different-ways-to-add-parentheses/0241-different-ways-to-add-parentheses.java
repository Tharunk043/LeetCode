import java.util.*;

class Solution {
    Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Try every operator as a split point
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') result.add(a + b);
                        else if (c == '-') result.add(a - b);
                        else if (c == '*') result.add(a * b);
                    }
                }
            }
        }
        
        // Base case: no operator found → it's a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        memo.put(expression, result);
        return result;
    }
}
