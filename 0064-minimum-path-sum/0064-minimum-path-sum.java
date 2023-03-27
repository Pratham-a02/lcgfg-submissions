class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return minPath(0,0,m,n,grid,dp);
    }
    
    public int minPath(int cr,int cc,int dr,int dc,int[][] grid,int[][] dp){
        if(cr == dr-1 && cc == dc-1){
            return grid[cr][cc];
        }
        
        if(cr>=dr || cc >= dc){
            return (int)1e9;
        }
        
        if(dp[cr][cc] != -1){
            return dp[cr][cc];
        }
        
        int down = grid[cr][cc] + minPath(cr+1,cc,dr,dc,grid,dp);
        int right = grid[cr][cc] + minPath(cr,cc+1,dr,dc,grid,dp);
        
        
        return dp[cr][cc] = Math.min(down,right);
    }
}