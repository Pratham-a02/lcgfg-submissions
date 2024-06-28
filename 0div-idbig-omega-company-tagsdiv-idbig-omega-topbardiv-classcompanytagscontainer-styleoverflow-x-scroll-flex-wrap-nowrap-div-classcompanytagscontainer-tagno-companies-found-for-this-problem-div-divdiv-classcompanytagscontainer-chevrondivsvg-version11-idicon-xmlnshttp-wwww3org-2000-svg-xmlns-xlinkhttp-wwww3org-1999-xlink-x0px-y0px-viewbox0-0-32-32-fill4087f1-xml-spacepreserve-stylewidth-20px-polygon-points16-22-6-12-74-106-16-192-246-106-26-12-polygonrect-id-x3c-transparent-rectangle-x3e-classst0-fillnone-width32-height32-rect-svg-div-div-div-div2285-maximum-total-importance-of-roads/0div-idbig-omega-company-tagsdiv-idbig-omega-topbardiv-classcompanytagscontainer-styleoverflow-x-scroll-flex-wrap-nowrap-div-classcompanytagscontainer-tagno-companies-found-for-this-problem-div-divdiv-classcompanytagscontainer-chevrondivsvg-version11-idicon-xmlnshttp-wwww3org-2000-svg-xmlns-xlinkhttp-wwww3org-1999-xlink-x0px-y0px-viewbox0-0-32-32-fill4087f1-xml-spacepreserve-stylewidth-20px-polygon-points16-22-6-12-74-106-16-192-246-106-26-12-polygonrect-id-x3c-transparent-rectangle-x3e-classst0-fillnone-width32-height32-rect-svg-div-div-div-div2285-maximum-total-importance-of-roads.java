class Pair implements Comparable<Pair>{
    int vert;
    int degree;
    
    Pair(int vert,int degree){
        this.vert = vert;
        this.degree = degree;
    }
    
    public int compareTo(Pair o){
        
            return o.degree - this.degree;
        
    }
}
class Solution{
    public long maximumImportance(int n,int[][] roads){
        int[] indegree = new int[n];
        for(int[] road:roads){
            int u = road[0];
            int v = road[1];    
            indegree[u]++;
            indegree[v]++;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 0;i<indegree.length;i++){
            pq.add(new Pair(i,indegree[i]));
        }
        
        int val = n;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        while(pq.size()>0){
            Pair p = pq.remove();
            hm.put(p.vert,n);
            n--;
        }
        
        long ans = 0;
        for(int[] road:roads){
            ans += (hm.get(road[0]) + hm.get(road[1]));
        }
        
        return ans;
    }
}