import java.util.*;

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];

        // counts of each number
        Map<Integer, Long> countMap = new HashMap<>();

        // freqCount[f] = how many numbers have frequency f
        TreeMap<Long, Integer> freqCount = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            long delta = freq[i];

            long oldFreq = countMap.getOrDefault(num, 0L);
            long newFreq = oldFreq + delta;

            // Remove old frequency from freqCount
            if (oldFreq > 0) {
                int cnt = freqCount.getOrDefault(oldFreq, 0);
                if (cnt == 1) freqCount.remove(oldFreq);
                else freqCount.put(oldFreq, cnt - 1);
            }

            // Update the number's frequency
            if (newFreq > 0) {
                countMap.put(num, newFreq);
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
            } else {
                countMap.remove(num);
            }

            // The largest key in freqCount is the current max frequency
            ans[i] = freqCount.isEmpty() ? 0 : freqCount.lastKey();
        }
        return ans;
    }
}
