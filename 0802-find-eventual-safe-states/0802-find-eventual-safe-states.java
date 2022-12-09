class Solution {
    int[] vis;
    public List<Integer> eventualSafeNodes(int[][] graph) {
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
    
    public boolean dfs(int v,int[][] graph){
        if(vis[v] == 2){
            return true;
        }
        else if(vis[v] == 1){
            return false;
        }
        else{
            for(int nbr:graph[v]){
                vis[v] = 1;
                boolean isSafe = dfs(nbr,graph);
                
                if(!isSafe){
                    return false;
                }
            }
            vis[v] = 2;
            return true;
        }
    }
}