class Solution{
    int mod = (int)1e9 + 7;
    public int findPaths(int m,int n,int maxMove,int startRow,int startColumn){
        int[][][] dp = new int[51][51][51];
        for(int[][] d:dp){
            for(int[]d1:d){
                Arrays.fill(d1,-1);
            }
        }
        return findPaths_R(m,n,maxMove,startRow,startColumn,dp);
    }
    
    public int findPaths_R(int m,int n,int k,int row,int column,int[][][] dp){
        if(row<0 || column<0 || row==m || column==n){
            return 1;
        }
        if(k == 0){
            return 0;
        }
        
        if(dp[k][row][column] != -1){
            return dp[k][row][column];
        }
        
        int count = 0;
        count += findPaths_R(m,n,k-1,row-1,column,dp);
        count = count%mod;
        count += findPaths_R(m,n,k-1,row,column+1,dp);
        count = count%mod;
        count += findPaths_R(m,n,k-1,row+1,column,dp);
        count = count%mod;
        count += findPaths_R(m,n,k-1,row,column-1,dp);
        count = count%mod;
        
        return dp[k][row][column] = count%mod;
    }
}