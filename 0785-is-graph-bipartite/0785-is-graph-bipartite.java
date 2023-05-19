class Solution{
    public boolean isBipartite(int[][] graph){
        int n = graph.length;
        int[] colors = new int[graph.length];
        
        Arrays.fill(colors,-1);
        
        for(int i = 0;i<n;i++){
            if(colors[i] != -1){
                continue;
            }
            if(dfs(i,colors,0,graph) == false){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int currVert,int[] colors,int color,int[][] graph){
        if(colors[currVert] != -1){
            return colors[currVert] == color;
        }
        
        colors[currVert] = color;
        
        for(int nbr : graph[currVert]){
            if(dfs(nbr,colors,1-color,graph) == false){
                return false;
            }
            
        }
        return true;
    }
}