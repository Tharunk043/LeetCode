import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Build graph
        List<List<double[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new double[]{v, prob});
            graph.get(v).add(new double[]{u, prob});
        }
        
        // Max heap: [probability, node]
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        pq.offer(new double[]{1.0, start_node});
        
        double[] prob = new double[n];
        prob[start_node] = 1.0;
        
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double p = curr[0];
            int node = (int) curr[1];
            
            if (node == end_node) return p; // found best path
            
            for (double[] nei : graph.get(node)) {
                int next = (int) nei[0];
                double edgeProb = nei[1];
                double newProb = p * edgeProb;
                
                if (newProb > prob[next]) {
                    prob[next] = newProb;
                    pq.offer(new double[]{newProb, next});
                }
            }
        }
        
        return 0.0;
    }
}
