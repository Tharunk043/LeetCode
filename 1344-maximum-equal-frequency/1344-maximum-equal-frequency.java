import java.util.*;

class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(); // number -> freq
        Map<Integer, Integer> freq = new HashMap<>();  // freq -> how many numbers have this freq
        int maxFreq = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            
            // Remove old frequency
            if (count.containsKey(x)) {
                int oldFreq = count.get(x);
                freq.put(oldFreq, freq.get(oldFreq) - 1);
                if (freq.get(oldFreq) == 0) freq.remove(oldFreq);
            }

            // Update new frequency
            int newFreq = count.getOrDefault(x, 0) + 1;
            count.put(x, newFreq);
            freq.put(newFreq, freq.getOrDefault(newFreq, 0) + 1);

            maxFreq = Math.max(maxFreq, newFreq);

            int total = i + 1;
            boolean valid = false;

            // Case 1: all numbers appear once
            if (maxFreq == 1) valid = true;

            // Case 2: all numbers same freq, except one appears once
            else if (freq.get(maxFreq) * maxFreq + 1 == total) valid = true;

            // Case 3: all numbers same freq, except one number has +1 freq
            else if (freq.get(maxFreq) * maxFreq + (maxFreq - 1) * (freq.getOrDefault(maxFreq - 1, 0)) == total
                     && freq.get(maxFreq) == 1) valid = true;

            if (valid) res = total;
        }

        return res;
    }
}
