class Solution {
    public int minCostClimbingStairs(int[] cost){
        int[] dp = new int[cost.length+1];
        return minCost(cost.length,cost,dp);
    }
    /*
    public int minCost(int n,int[] cost,int[] dp){
        if(n<=1){
            return dp[n] = cost[n];
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        return dp[n] = Math.min(minCost(n-1,cost,dp),minCost(n-2,cost,dp)) + (n == cost.length?0:cost[n]);
    }
    */
    
    public int minCost(int N,int[] cost,int[] dp){
        for(int n = 0;n<=N;n++){
            if(n<=1){
                dp[n] = cost[n];
                continue;
            }
        
            dp[n] = Math.min(dp[n-1],dp[n-2]) + (n == cost.length?0:cost[n]);
        }
        return dp[N];
    }
}