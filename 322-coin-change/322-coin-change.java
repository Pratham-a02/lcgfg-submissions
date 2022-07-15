class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[]d : dp)
            Arrays.fill(d,-1);
        int ans = minCoins(0,amount,coins,dp);
        if(ans == 100000)
            return -1;
        return ans;
    }
    public int minCoins(int currIdx,int amount,int[] coins,int[][] dp){
        if(amount == 0)
            return 0;
        if(currIdx>=coins.length)
            return 100000;
        if(dp[currIdx][amount]!= -1)
            return dp[currIdx][amount];
        // if(amount>coins[currIdx])
        //     return -1;
        
        int taken = 100000;
        
        if(coins[currIdx]<= amount)
            taken = 1 + minCoins(currIdx,amount-coins[currIdx],coins,dp);
        int notTaken = minCoins(currIdx+1,amount,coins,dp);
        
        dp[currIdx][amount] =  Math.min(taken,notTaken);
        return dp[currIdx][amount];
    }
}