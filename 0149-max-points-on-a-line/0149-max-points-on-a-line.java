import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int n = points.length;
        int maxPoints = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 1;  // count the current point itself
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++; // same point
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // normalize slope (avoid -0 / sign issues)
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1; // vertical line
                } else if (dy == 0) {
                    dx = 1; // horizontal line
                }

                String slope = dx + "/" + dy;
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(slope));
            }

            maxPoints = Math.max(maxPoints, localMax + duplicates);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
