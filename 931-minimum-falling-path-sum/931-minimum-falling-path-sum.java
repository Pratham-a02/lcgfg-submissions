class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        int res = (int)1e9;
        for(int i = 0;i<n;i++){
            res = Math.min(res,minPath(0,i,m-1,n-1,matrix,dp));
        }
        return res;
    }
    
    public int minPath(int currRow,int currCol,int destRow,int destCol,int[][] matrix,int[][] dp){
        if(currRow<0 || currRow>destRow || currCol<0 || currCol > destCol)
            return (int)1e9;
        
        if(currRow == destRow)
            return matrix[currRow][currCol];
        
        if(dp[currRow][currCol] != -1)
            return dp[currRow][currCol];
        
        int left = matrix[currRow][currCol] + minPath(currRow+1,currCol-1,destRow,destCol,matrix,dp);
        int down = matrix[currRow][currCol] + minPath(currRow+1,currCol,destRow,destCol,matrix,dp);
        int right = matrix[currRow][currCol] + minPath(currRow+1,currCol+1,destRow,destCol,matrix,dp);
        
        int first = Math.min(left,down);
        return dp[currRow][currCol] = Math.min(first,right);
    }
}