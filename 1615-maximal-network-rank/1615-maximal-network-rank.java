class Solution {
    public int maximalNetworkRank(int n, int[][] roads){
        int[] degree = new int[101];
        for(int[] road:roads){
            int u = road[0];
            int v = road[1];
            degree[u]++;
            degree[v]++;
        }   
        boolean[][] vis = new boolean[n][n];
        for(int[] road:roads){
            int u = road[0];
            int v = road[1];
            
            vis[u][v] = true;
            vis[v][u] = true;
        }
        int max = 0;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(vis[i][j] == true){
                    max = Math.max(max,degree[i] + degree[j]-1);
                }else{
                    max = Math.max(max,degree[i] + degree[j]);
                }
            }
        }
        return max;
    }
}