class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<restricted.length;i++){
            hs.add(restricted[i]);
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            // if(u<v){
                graph.get(u).add(v);
            // }else{
                graph.get(v).add(u);
            }
        boolean[] vis = new boolean[n];
        return dfs(0,graph,hs,vis);
        }
        

    
    
    public int dfs(int src,List<List<Integer>> graph,HashSet<Integer> hs,boolean[] vis){
        if(hs.contains(src)){
            return 0;
        }
        vis[src] = true;
        int ans = 0;
        
        if(graph.get(src).size() != 0){
            for(int nbr:graph.get(src)){
                if(!hs.contains(nbr) && !vis[nbr]){
                    ans += dfs(nbr,graph,hs,vis);
                }
            }
        }
        
        return ans+1;
    }
}