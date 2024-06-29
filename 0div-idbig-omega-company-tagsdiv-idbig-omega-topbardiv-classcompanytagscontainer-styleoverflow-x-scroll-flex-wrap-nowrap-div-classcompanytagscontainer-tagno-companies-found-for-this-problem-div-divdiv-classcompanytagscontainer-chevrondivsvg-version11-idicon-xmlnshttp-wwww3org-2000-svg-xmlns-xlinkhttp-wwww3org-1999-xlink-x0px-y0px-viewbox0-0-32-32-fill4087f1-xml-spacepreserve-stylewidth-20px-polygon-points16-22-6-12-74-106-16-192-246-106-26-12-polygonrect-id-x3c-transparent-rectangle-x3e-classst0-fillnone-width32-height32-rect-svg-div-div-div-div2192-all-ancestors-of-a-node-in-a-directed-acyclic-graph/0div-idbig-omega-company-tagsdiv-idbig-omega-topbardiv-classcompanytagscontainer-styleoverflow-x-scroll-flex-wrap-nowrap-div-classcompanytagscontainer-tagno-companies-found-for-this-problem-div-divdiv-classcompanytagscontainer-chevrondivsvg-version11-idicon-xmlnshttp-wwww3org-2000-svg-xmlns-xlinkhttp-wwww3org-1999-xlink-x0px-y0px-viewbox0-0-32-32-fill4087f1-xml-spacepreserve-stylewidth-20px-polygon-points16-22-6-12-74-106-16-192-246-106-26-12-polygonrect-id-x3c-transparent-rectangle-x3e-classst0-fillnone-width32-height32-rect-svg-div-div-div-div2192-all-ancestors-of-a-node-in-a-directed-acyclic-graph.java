class Solution{
    public List<List<Integer>> getAncestors(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        
        for(int i = 0;i<n;i++){
            boolean[] vis = new boolean[n];
            dfs(i,vis,n,graph);
            
            for(int j = 0;j<n;j++){
                if(i == j){
                    continue;
                }
                if(vis[j] == true){
                    ans.get(j).add(i);
                }
            }
        }
        return ans;
    }
    
    public void dfs(int src,boolean[] vis,int n,List<List<Integer>> graph){
        vis[src] = true;
        
        for(int nbr:graph.get(src)){
            if(!vis[nbr]){
                dfs(nbr,vis,n,graph);
            }
        }
        return;
    }
}