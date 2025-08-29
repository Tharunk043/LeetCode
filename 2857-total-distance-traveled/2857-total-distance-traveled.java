class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int distance = 0;
        
        while (mainTank > 0) {
            // consume 1 liter from main tank
            mainTank--;
            distance += 10;
            
            // every 5 liters consumed, transfer 1 from additional if available
            if (distance % 50 == 0 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }
        
        return distance;
    }
}
