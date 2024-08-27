class Pair implements Comparable<Pair> {
    int x;
    double val;

    Pair(int x, double val) {
        this.x = x;
        this.val = val;
    }

    @Override
    public int compareTo(Pair o) {
        return Double.compare(o.val, this.val);  // max-heap: higher probability first
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start_node, 1.0));  // Start with probability 1.0
        List<List<Pair>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            al.get(u).add(new Pair(v, prob));
            al.get(v).add(new Pair(u, prob));
        }

        boolean[] vis = new boolean[n];
        double max = 0.0;
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (vis[rem.x]) {
                continue;
            }
            vis[rem.x] = true;

            if (rem.x == end_node) {
                max = rem.val;
            }

            for (Pair nbr : al.get(rem.x)) {
                if (!vis[nbr.x]) {
                    pq.add(new Pair(nbr.x, rem.val * nbr.val));
                }
            }
        }
        return max;
    }
}
