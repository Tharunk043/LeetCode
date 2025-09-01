import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int ans = -1, maxFreq = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);

                int count = freq.get(num);
                if (count > maxFreq || (count == maxFreq && num < ans)) {
                    ans = num;
                    maxFreq = count;
                }
            }
        }

        return ans;
    }
}
