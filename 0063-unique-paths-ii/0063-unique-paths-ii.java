class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,0,m-1,n-1,obstacleGrid,dp);
    }
    
    public int solve(int currRow,int currCol,int destRow,int destCol,int[][] grid,int[][] dp){
        if(currRow == grid.length-1 && currCol == grid[0].length-1){
            return 1;
        }
        
        if(currRow<0 || currCol<0 || currRow>=grid.length || currCol>=grid[0].length || grid[currRow][currCol] == 1){
            return 0;
        }
        if(dp[currRow][currCol] != -1){
            return dp[currRow][currCol];
        }
        int count = 0;
        
        count += solve(currRow+1,currCol,destRow,destCol,grid,dp) + solve(currRow,currCol+1,destRow,destCol,grid,dp);
        
        return dp[currRow][currCol] = count;
    }
}