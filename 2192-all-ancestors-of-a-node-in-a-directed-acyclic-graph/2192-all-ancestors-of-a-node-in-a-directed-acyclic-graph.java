class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges){
        List<List<Integer>> ans = new ArrayList<>();
        // boolean[] vis = new boolean[n];
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0;i<n;i++){
            al.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            al.get(u).add(v);
        }
        
        for(int i = 0;i<n;i++){
            boolean[] vis = new boolean[n];
            dfs(vis,i,al);
            
            for(int j = 0;j<n;j++){
                if(i==j){
                    continue;
                }
                
                if(vis[j]){
                    ans.get(j).add(i);
                }
            }
        }
        
        return ans;
    }
    
    public void dfs(boolean[] vis,int src,List<List<Integer>> al){
        vis[src] = true;
        
        for(int nbr:al.get(src)){
            if(!vis[nbr]){
                dfs(vis,nbr,al);
            }
        }
    }
}