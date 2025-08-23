class Solution {
    private static final int MOD = 1000000007;
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        long maxKadane = kadane(arr);
        if (k == 1) return (int)(maxKadane % MOD);
        
        long totalSum = 0;
        for (int num : arr) totalSum += num;
        
        long prefix = maxPrefix(arr);
        long suffix = maxSuffix(arr);
        
        long result;
        if (totalSum > 0) {
            result = prefix + suffix + (long)(k - 2) * totalSum;
        } else {
            result = Math.max(maxKadane, prefix + suffix);
        }
        
        return (int)(Math.max(result, 0) % MOD);
    }
    
    // Kadane's algorithm
    private long kadane(int[] arr) {
        long maxEndingHere = 0, maxSoFar = 0;
        for (int num : arr) {
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
    // Max prefix sum
    private long maxPrefix(int[] arr) {
        long sum = 0, maxSum = Long.MIN_VALUE;
        for (int num : arr) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    
    // Max suffix sum
    private long maxSuffix(int[] arr) {
        long sum = 0, maxSum = Long.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
