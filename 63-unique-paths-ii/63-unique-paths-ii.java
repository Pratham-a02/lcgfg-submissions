class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        
        return totalWays(0,0,m-1,n-1,obstacleGrid,dp);
    }
    
    public int totalWays(int currRow,int currCol,int destRow,int destCol,int[][] obstacleGrid,int[][] dp){
        if(currRow>destRow || currCol>destCol || obstacleGrid[currRow][currCol] == 1)
            return 0;
        if(currRow == destRow && currCol == destCol)
            return 1;
        
        if(dp[currRow][currCol] != -1)
            return dp[currRow][currCol];
        int right = totalWays(currRow,currCol+1,destRow,destCol,obstacleGrid,dp);
        int down = totalWays(currRow+1,currCol,destRow,destCol,obstacleGrid,dp);
        
        return dp[currRow][currCol] = right+down;
    }
}