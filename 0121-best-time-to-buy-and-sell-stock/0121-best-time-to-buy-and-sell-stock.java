class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max =0;
        for(int i=0 ;i<prices.length;i++){
            buy = Math.min(prices[i],buy);
            max =Math.max(max,prices[i]-buy);
        }
        return max;
    }
}