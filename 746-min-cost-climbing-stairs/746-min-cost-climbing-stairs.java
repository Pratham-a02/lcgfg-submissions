class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+2];
        Arrays.fill(dp,-1);
        int a = minCost(cost,0,dp);
        int b = minCost(cost,1,dp);
        return Math.min(a,b);
    }
    public int minCost(int[] cost,int currIdx,int[] dp){
        if(currIdx == cost.length)
            return 0;
        if(currIdx > cost.length)
            return (int)1e9;
        if(dp[currIdx] != -1)
            return dp[currIdx];
        
        int oneStep = cost[currIdx] + minCost(cost,currIdx+1,dp);
        int twoStep = cost[currIdx] + minCost(cost,currIdx+2,dp);
        
        dp[currIdx] = Math.min(oneStep,twoStep);
        return dp[currIdx];
    }
}