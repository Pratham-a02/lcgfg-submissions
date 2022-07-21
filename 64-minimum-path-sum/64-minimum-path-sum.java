class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        return minSum(0,0,m-1,n-1,grid,dp);
    }
    
    public int minSum(int currRow,int currCol,int destRow,int destCol,int[][] grid,int[][] dp){
        if(currRow>destRow || currCol>destCol)
            return (int)1e9;
        if(currRow == destRow && currCol == destCol)
            return grid[currRow][currCol];
        
        if(dp[currRow][currCol] != -1)
            return dp[currRow][currCol];
        
        int right = grid[currRow][currCol] + minSum(currRow,currCol+1,destRow,destCol,grid,dp); 
        int down = grid[currRow][currCol] + minSum(currRow+1,currCol,destRow,destCol,grid,dp); 
        
        return dp[currRow][currCol] = Math.min(right,down);
    }
}