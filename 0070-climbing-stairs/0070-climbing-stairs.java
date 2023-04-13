class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climbStairs_Tab(n,dp);
    }
    
    public static int climbStairs_Tab(int N,int[] dp){
        for(int n = 0;n<=N;n++){
            if(n<=1){
                dp[n] = 1;
                continue;
            }

            dp[n] = dp[n-1] + dp[n-2];//climbStairs_M(n-1,dp);
        }
        return dp[N];
    }
}