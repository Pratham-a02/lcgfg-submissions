class Solution {
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        int extraEdge = 0;
        int nc = 0;
        for(int[]connection:connections){
            int ul = find(connection[0]);
            int vl = find(connection[1]);
            
            if(ul!=vl){
                union(ul,vl);
            }else{
                extraEdge++;
            }
        }
        for(int i = 0;i<parent.length;i++){
            if(parent[i] == i){
                nc++;
            }
        }
        int ans = nc-1;
        if(extraEdge>=ans){
            return ans;
        }
        else{
            return -1;
        }
    }
    
    int[] parent;
    int[] rank;
    
    public int find(int x){
        if(parent[x] == x){
            return parent[x];
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int x,int y){
        if(rank[x]>rank[y]){
            parent[y] = x;
            rank[x]++;
        }
        else if(rank[x]<rank[y]){
            parent[x] = y;
            rank[y]++;
        }
        else{
            parent[y] = x;
            rank[x]++;
        }
    }
}