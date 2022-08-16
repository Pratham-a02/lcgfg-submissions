class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[101][101];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        int max = (int)1e9;
        for(int j = 0;j<n;j++){
            max = Math.min(max,grid[0][j] + minCost(0,j,grid,moveCost,m-1,n-1,dp));
        }
        return max;
    }
    
    public int minCost(int currRow,int currCol,int[][] grid,int[][] moveCost,int destRow,int destCol,int[][] dp){
        if(currRow == destRow){
            return 0;
        }
        if(dp[currRow][currCol] != -1){
            return dp[currRow][currCol];
        }
        
        int cost = (int)1e9;
        for(int nex = 0;nex<=destCol;nex++){ 
            int spent = grid[currRow +1][nex] + moveCost[grid[currRow][currCol]][nex];
            cost = Math.min(cost,spent + minCost(currRow+1,nex,grid,moveCost,destRow,destCol,dp));
        }
        return dp[currRow][currCol] = cost;
    }
}