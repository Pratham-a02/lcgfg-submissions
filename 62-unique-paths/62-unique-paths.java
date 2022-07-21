class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        return totalWays(0,0,m-1,n-1,dp);
    }
    
    public int totalWays(int currRow,int currCol,int destRow,int destCol,int[][] dp){
        if(currRow>destRow || currCol>destCol)
            return 0;
        if(currRow == destRow && currCol == destCol)
            return 1;
        
        if(dp[currRow][currCol]!= -1)
            return dp[currRow][currCol];
        
        int right = totalWays(currRow,currCol+1,destRow,destCol,dp);
        int down = totalWays(currRow+1,currCol,destRow,destCol,dp);
        
        return dp[currRow][currCol] = right+down;
    }
}