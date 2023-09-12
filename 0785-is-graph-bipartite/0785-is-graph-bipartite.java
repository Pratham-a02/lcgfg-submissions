class Solution{
    public boolean isBipartite(int[][] graph){
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        
        for(int i = 0;i<graph.length;i++){
            if(color[i] != -1){
                continue;
            }
            
            if(solve(i,0,color,graph) == false){
                return false;
            }
        }
        return true;
    }
    
    public boolean solve(int vert,int col,int[] color,int[][] graph){
        if(color[vert] != -1){
            return color[vert] == col;
        }
        
        color[vert] = col;
        for(int nbr:graph[vert]){
            if(solve(nbr,1-col,color,graph) == false){
                return false;
            }
        }
        return true;
    }
}