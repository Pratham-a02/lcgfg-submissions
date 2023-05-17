class Solution{
    public boolean isBipartite(int[][] graph){
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        
        for(int i = 0;i<n;i++){
            if(color[i] != -1){
                continue;
            }
            if(dfs(i,0,color,graph) == false){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int vert,int curr,int[] color,int[][] graph){
        if(color[vert] != -1){
            return (curr == color[vert]);
        }
        color[vert] = curr;
        
        for(int nbr:graph[vert]){
            if(dfs(nbr,1-curr,color,graph) == false){
                return false;
            }
        }
        return true;
    }
}