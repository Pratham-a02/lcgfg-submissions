class Solution {
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        for(int[][] d:dp){
            for(int[] d_:d){
                Arrays.fill(d_ , -1);
            }
        }
        return solve(n,0,0,dp)%1000000007;
    }
    
    public int solve(int n,int abDay,int consDay,int[][][] dp){
        if(abDay>1 || consDay>2){
            return 0;
        }
        
        if(n == 0){
            return 1;
        }
        
        if(dp[n][abDay][consDay] != -1){
            return dp[n][abDay][consDay];
        }
        int p = 0, l = 0, a = 0;
        p += solve(n-1,abDay,0,dp)%1000000007;
        a += solve(n-1,abDay+1,0,dp)%1000000007;
        l += solve(n-1,abDay,consDay+1,dp)%1000000007;
        
        return dp[n][abDay][consDay] = (p+(a+l)%1000000007)%1000000007;
    }
}