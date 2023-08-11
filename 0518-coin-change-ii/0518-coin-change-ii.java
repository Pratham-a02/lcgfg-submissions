class Solution {
    public int change(int amount, int[] coins){
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,amount,coins,dp);
    }
    
    public int solve(int idx,int amount,int[] coins,int[][] dp){
        if(amount == 0) return 1;
        
        if(idx>=coins.length) return 0;
        
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        
        int taken = 0;
        
        if(amount - coins[idx] >= 0){
            taken = solve(idx,amount-coins[idx],coins,dp);
        }
        int notTaken = solve(idx+1,amount,coins,dp);
        
        return dp[idx][amount] = taken + notTaken;
    }
}