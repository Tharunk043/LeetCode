import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int radius = 0;
        for (int house : houses) {
            // find the closest heater using binary search
            int pos = Arrays.binarySearch(heaters, house);
            if (pos < 0) {
                pos = -(pos + 1); // insertion point
            }
            
            int dist1 = (pos - 1 >= 0) ? house - heaters[pos - 1] : Integer.MAX_VALUE;
            int dist2 = (pos < heaters.length) ? heaters[pos] - house : Integer.MAX_VALUE;
            int closest = Math.min(dist1, dist2);
            
            radius = Math.max(radius, closest);
        }
        
        return radius;
    }
}
