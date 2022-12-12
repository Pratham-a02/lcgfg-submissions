class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            int ul = find(u);
            int vl = find(v);
            
            if(ul!=vl){
                union(ul,vl);
            }
        }
        
        int srcl = find(source);
        int destl = find(destination);
        
        if(srcl != destl){
            return false;
        }
        else{
            return true;
        }
    }
    int[] parent;
    int[] rank;
    
    public int find(int x){
        if(parent[x] == x){
            return x;
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