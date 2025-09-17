class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        // Step 2: Bucket where index = frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int f = freqMap.get(key);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(key);
        }

        // Step 3: Collect top k
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }

        // Convert list to array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = result.get(i);
        return res;
    }
}
