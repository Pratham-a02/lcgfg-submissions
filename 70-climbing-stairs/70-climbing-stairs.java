class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return totalWays(n,dp);
    }
    
    public int totalWays(int n,int[] dp){
        if(n == 0)
            return dp[n] = 1;
        if(n<0)
            return 0;
        if(dp[n]!= -1)
            return dp[n];

        int nm1 = totalWays(n-1,dp);
        int nm2 = totalWays(n-2,dp);
        
        return dp[n] = nm1 + nm2;
    }
}
