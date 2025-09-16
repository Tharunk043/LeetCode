import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        
        for (int num : nums) {
            stack.add(num);
            
            // Try merging as long as top two are not coprime
            while (stack.size() > 1) {
                int a = stack.get(stack.size() - 2);
                int b = stack.get(stack.size() - 1);
                int g = gcd(a, b);
                if (g == 1) break; // coprime → stop merging
                
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                
                long lcm = (long) a / g * b; // prevent overflow
                stack.add((int) lcm);
            }
        }
        
        return stack;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
