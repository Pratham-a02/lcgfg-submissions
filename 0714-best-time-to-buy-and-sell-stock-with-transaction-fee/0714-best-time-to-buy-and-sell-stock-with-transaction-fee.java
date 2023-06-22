class Solution{
    public int maxProfit(int[] prices, int fee){
        int[][] dp = new int[prices.length + 1][2];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,1,prices,fee,dp);
    }
    
    
    public int solve(int idx,int canBuy,int[] prices,int fee,int[][] dp){
        if(idx >= prices.length) return 0;
        
        if(dp[idx][canBuy] != -1){
            return dp[idx][canBuy];
        }
        
        if(canBuy == 1){
            int idle = solve(idx+1,1,prices,fee,dp);
            int buy = -prices[idx] + solve(idx+1,0,prices,fee,dp);
            return dp[idx][canBuy] = Math.max(idle,buy);
        }
        else{
            int idle = solve(idx+1,0,prices,fee,dp);
            int sell = -fee + prices[idx] + solve(idx+1,1,prices,fee,dp);
            return dp[idx][canBuy] = Math.max(idle,sell);
        }
    }
}