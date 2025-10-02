class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles;   // total bottles drunk
        int empty = numBottles;   // current empty bottles

        while (empty >= numExchange) {
            empty -= numExchange;  // spend bottles for exchange
            total += 1;            // drink the new one
            empty += 1;            // that bottle also becomes empty
            numExchange++;         // next exchange requires more bottles
        }

        return total;
    }
}
