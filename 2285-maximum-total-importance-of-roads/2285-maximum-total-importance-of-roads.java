class Pair implements Comparable<Pair>{
    int idx;
    int deg;
    
    Pair(int idx,int deg){
        this.idx = idx;
        this.deg = deg;
    }
    public int compareTo(Pair o){
        return o.deg - this.deg;
    }
}

class Solution {
    public long maximumImportance(int n, int[][] roads){
        int[] degree = new int[n];
        for(int[] road:roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<degree.length;i++){
            pq.add(new Pair(i,degree[i]));
        }
        int[] imp = new int[n];
        while(pq.size()>0){
            Pair rem = pq.remove();
            int index = rem.idx;
            imp[index] = n;
            n--;
        }
        
        long ans = 0;
        for(int[] road:roads){
            int u = road[0];
            int v = road[1];
            
            ans += imp[u] + imp[v];
        }
        return ans;
    }
}