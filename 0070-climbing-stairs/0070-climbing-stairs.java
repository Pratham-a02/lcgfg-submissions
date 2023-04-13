class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climbStairs_M(n,dp);
    }
    
    public int climbStairs_M(int n,int[] dp){
        if(n<=1){
            return dp[n] = 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = climbStairs_M(n-1,dp) + climbStairs_M(n-2,dp);
    }
}