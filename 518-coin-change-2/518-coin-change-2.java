class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[]d : dp)
            Arrays.fill(d,-1);
        return totalComb(0,coins,amount,dp);
    }
    
    public int totalComb(int currIdx,int[] coins,int amount,int[][] dp){
        if(amount == 0)
            return 1;
        if(currIdx>= coins.length)
            return 0;
        // if(amount>coins[currIdx])
        //     return 0;
        if(dp[currIdx][amount]!= -1)
            return dp[currIdx][amount];
        
        int taken = 0;
        if(coins[currIdx]<=amount)
            taken = totalComb(currIdx,coins,amount-coins[currIdx],dp);
        int notTaken = totalComb(currIdx+1,coins,amount,dp);
        
        return dp[currIdx][amount] = taken+notTaken;
    }
}