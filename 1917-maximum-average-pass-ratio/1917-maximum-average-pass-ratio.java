import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        // Put [gain, index] in the heap
        for (int i = 0; i < classes.length; i++) {
            int pass = classes[i][0], total = classes[i][1];
            double gain = gain(pass, total);
            pq.offer(new double[]{gain, i});
        }
        
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int i = (int) top[1];
            classes[i][0]++; // add one pass student
            classes[i][1]++;
            pq.offer(new double[]{gain(classes[i][0], classes[i][1]), i});
        }
        
        double sum = 0.0;
        for (int[] c : classes) {
            sum += (double) c[0] / c[1];
        }
        
        return sum / classes.length;
    }
    
    private double gain(int pass, int total) {
        return ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
