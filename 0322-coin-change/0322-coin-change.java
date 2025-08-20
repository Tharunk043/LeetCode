class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<=0) return 0;
        int[] mincoindp = new int[amount+1];
        for(int i = 1;i<=amount;i++){
            mincoindp[i] = Integer.MAX_VALUE;
            for(int coin:coins){
                if(coin<=i && mincoindp[i-coin]!=Integer.MAX_VALUE){
                    mincoindp[i] = Math.min(mincoindp[i],1+mincoindp[i-coin]);
                }
            }
        }
        if(mincoindp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return mincoindp[amount];
    }
}