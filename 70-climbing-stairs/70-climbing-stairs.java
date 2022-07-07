class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return totalWays(0,n,dp);
    }
    public int totalWays(int currStair,int targetStair,int[] dp){
        if(currStair == targetStair)
            return 1;
        if(currStair>targetStair)
            return 0;
        if(dp[currStair]!= -1)
            return dp[currStair];
        int oneStep = totalWays(currStair+1,targetStair,dp);
        int twoStep = totalWays(currStair+2,targetStair,dp);
        
        dp[currStair] = oneStep + twoStep;
        return dp[currStair];

    }
}