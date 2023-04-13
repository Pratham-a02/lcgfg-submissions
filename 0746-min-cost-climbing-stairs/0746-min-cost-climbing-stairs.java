class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        int zero = MinCost(0,cost,dp);
        int one = MinCost(1,cost,dp);
        return Math.min(zero,one);
    }
    
    public int MinCost(int idx,int[] cost,int[] dp){
        if(idx == cost.length){
            return 0;
        }
        if(idx>cost.length){
            return (int)1e9;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int oneStep = cost[idx] + MinCost(idx+1,cost,dp);
        int twoStep = cost[idx] + MinCost(idx+2,cost,dp);
        
        return dp[idx] = Math.min(oneStep,twoStep);
    }
}