class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                max = Math.max(max,solve(i,j,matrix,dp));
            }
        }
        return max;
    }
    
    public int solve(int i,int j,int[][] matrix,int[][] dp){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length){
            return 0;
        }
        
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        
        int currMax = 1;
        if(i-1>=0 && matrix[i-1][j]<matrix[i][j]){
            currMax = Math.max(currMax,1 + solve(i-1,j,matrix,dp));
        }
        if(j+1<matrix[0].length && matrix[i][j+1] < matrix[i][j]){
            currMax = Math.max(currMax,1 + solve(i,j+1,matrix,dp));
        }
        if(i+1<matrix.length && matrix[i+1][j] < matrix[i][j]){
            currMax = Math.max(currMax,1 + solve(i+1,j,matrix,dp));
        }
        if(j-1 >= 0 && matrix[i][j-1] < matrix[i][j]){
            currMax = Math.max(currMax,1 + solve(i,j-1,matrix,dp));
        }
        
        return dp[i][j] = currMax;
    }
}