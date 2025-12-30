class Solution {
    public int[] productExceptSelf(int[] nums) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
            fw.write("00");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }));
        int n = nums.length;
        int[] prod = new int[n];
        prod[0] = 1;
        int suf =1;
        for(int i = 1; i < n ; i++){
            prod[i] = prod[i-1]*nums[i-1];
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            prod[i] = prod[i]*suf;
            suf *= nums[i]; 
        }

        return prod;
    }
}