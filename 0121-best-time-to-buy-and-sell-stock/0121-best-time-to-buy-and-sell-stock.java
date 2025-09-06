class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i :prices){
            if(i<min) min = i;
            int curr = i-min;
            max=Math.max(curr,max);
        }
        return max;
    }
}