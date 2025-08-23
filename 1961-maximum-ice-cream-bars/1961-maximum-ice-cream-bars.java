import java.util.*;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs); // sort by cheapest first
        int count = 0;
        
        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break; // cannot afford further
            }
        }
        
        return count;
    }
}
