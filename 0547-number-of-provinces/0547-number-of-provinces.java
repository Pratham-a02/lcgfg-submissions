class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0;i<n;i++){
            al.add(new ArrayList<>());
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1){
                    if(i!=j){
                        al.get(i).add(j);
                    }
                }
            }
        }
        for(int i = 0;i<al.size();i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,al);
            }
        }
        return count;
    }
    
    public void dfs(int src,boolean[] vis,List<List<Integer>> graph){
        vis[src] = true;
        
        for(int nbr:graph.get(src)){
            if(!vis[nbr]){
                dfs(nbr,vis,graph);
            }
        }
        return;
    }
}