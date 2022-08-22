class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        for(int[][] d:dp){
            for(int[]d1:d){
                Arrays.fill(d1,-1);
            }
        }
        return bestTime(0,prices,k,1,dp);
    }
    public int bestTime(int currDay,int[] prices,int k,int canBuy,int[][][] dp){
        if(currDay>= prices.length || k <= 0){
            return 0;
        }
        
        if(dp[currDay][k][canBuy] != -1){
            return dp[currDay][k][canBuy];
        }
        
        if(canBuy == 1){
            int idle = bestTime(currDay+1,prices,k,1,dp);
            int buy = -prices[currDay] + bestTime(currDay+1,prices,k,0,dp);
            return dp[currDay][k][canBuy] = Math.max(idle,buy);
        }
        else{
            int idle = bestTime(currDay+1,prices,k,0,dp);
            int sell = prices[currDay] + bestTime(currDay+1,prices,k-1,1,dp);
            return dp[currDay][k][canBuy] = Math.max(idle,sell);
        }
    }
}