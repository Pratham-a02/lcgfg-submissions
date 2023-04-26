class Solution {
    int[] parent;
    int[] rank;
    
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
        
        for(int i = 0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[] edge:edges){
            int xl = find(edge[0]);
            int yl = find(edge[1]);
            
            if(xl != yl){
                union(xl,yl);
            }
            else{
                return edge;
            }
        }
        return null;
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int s1,int s2){
        if(rank[s1] < rank[s2]){
            parent[s1] = s2;
            rank[s2]++;
        }
        else if(rank[s2] < rank[s1]){
            parent[s2] = s1;
            rank[s1]++;
        }
        else{
            parent[s2] = s1;
            rank[s1]++;
        }
    }
}