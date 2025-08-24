class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int q = queries.length;
        int[] res = new int[q];
        
        for (int qi = 0; qi < q; qi++) {
            int k = queries[qi][0];
            int trim = queries[qi][1];
            
            int n = nums.length;
            String[][] arr = new String[n][2]; // [trimmed number, index]
            
            for (int i = 0; i < n; i++) {
                String trimmed = nums[i].substring(nums[i].length() - trim);
                arr[i][0] = trimmed;
                arr[i][1] = String.valueOf(i);
            }
            
            Arrays.sort(arr, (a, b) -> {
                int cmp = a[0].compareTo(b[0]); // lexicographic (same length → numeric order)
                if (cmp == 0) {
                    return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
                }
                return cmp;
            });
            
            res[qi] = Integer.parseInt(arr[k - 1][1]);
        }
        
        return res;
    }
}
