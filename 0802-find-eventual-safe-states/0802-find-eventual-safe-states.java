class Solution{
    int[] vis;
    public List<Integer> eventualSafeNodes(int[][] graph){
        vis = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0;i<graph.length;i++){
            boolean safe = dfs(i,graph);
            
            if(safe){
                ans.add(i);
            }
        }
        return ans;
    }
    
    public boolean dfs(int u,int[][] graph){
        if(vis[u] == 2){
            return true;
        }
        else if(vis[u] == 1){
            return false;
        }
        else{
            for(int nbr:graph[u]){
                vis[u] = 1;
                boolean safe = dfs(nbr,graph);
                
                if(!safe){
                    return false;
                }
            }
            vis[u] = 2;
            return true;
        }
    }
}