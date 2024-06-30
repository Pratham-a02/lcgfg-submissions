class Solution{
    int[] alice;
    int[] bob;
    int[] rank1;
    int[] rank2;
    public int maxNumEdgesToRemove(int n,int[][] edges){
        Arrays.sort(edges,(a,b)->{
            return b[0] - a[0];
        });
        
        alice = new int[n+1];
        bob = new int[n+1];
        rank1 = new int[n+1];
        rank2 = new int[n+1];
        
        for(int i = 0;i<n;i++){
            alice[i] = i;
            bob[i] = i;
            rank1[i] = 1;
            rank2[i] = 1;
        }
        
        int cnt1 = 1;
        int cnt2 = 1;
        int removed = 0;
        
        for(int[] edge:edges){
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            
            if(type == 3){
                int pu = find(u,alice);
                int pv = find(v,bob);
                
                if(pu == pv){
                    removed++;
                }
                else{
                    union(pu,pv,alice,rank1);
                    union(pu,pv,bob,rank2);
                    cnt1++;
                    cnt2++;
                }
            }
            else if(type == 1){
                int pu = find(u,alice);
                int pv = find(v,alice);
                if(pu == pv){
                    removed++;
                }
                else{
                    union(pu,pv,alice,rank1);
                    cnt1++;
                }
            }
            else{
                int pu = find(u,bob);
                int pv = find(v,bob);
                if(pu == pv){
                    removed++;
                }
                else{
                    union(pu,pv,bob,rank2);
                    cnt2++;
                }
            }
        }
        
        if(cnt1 != n || cnt2 != n){
            return -1;
        }
        
        return removed;
    }
    
    public int find(int x,int[] parent){
        if(parent[x] == x){
            return parent[x];
        }
        else{
            int cp = parent[x];
            int op = find(cp,parent);
            parent[x] = op;
            return op;
        }
    }
    
    public void union(int x,int y,int[] parent,int[] rank){
        if(rank[x]>rank[y]){
            rank[x]++;
            parent[y] = x;
        }
        else if(rank[x]<rank[y]){
            rank[y]++;
            parent[x] = y;
        }
        else{
            rank[x]++;
            parent[y] = x;
        }
    }
}