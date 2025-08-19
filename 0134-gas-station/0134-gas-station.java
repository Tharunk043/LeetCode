class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;   // total gas - cost over all stations
        int tank = 0;    // current tank
        int start = 0;   // starting station candidate
        
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            
            // if tank goes negative, reset start
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return total >= 0 ? start : -1;
    }
}
