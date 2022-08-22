class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return bestTime(0,prices,1,dp);
    }
    public int bestTime(int currDay,int[] prices,int canBuy,int[][] dp){
        if(currDay >= prices.length){
            return 0;
        }
        
        if(dp[currDay][canBuy] != -1){
            return dp[currDay][canBuy];
        }
        
        if(canBuy == 1){
            int idle = bestTime(currDay+1,prices,1,dp);
            int buy =  -prices[currDay] + bestTime(currDay+1,prices,0,dp);
            return dp[currDay][canBuy] = Math.max(idle,buy);
        }
        else{
            int idle = bestTime(currDay+1,prices,0,dp);
            int sell = prices[currDay] + bestTime(currDay+2,prices,1,dp);
            return dp[currDay][canBuy] = Math.max(idle,sell);
        }
    }
}