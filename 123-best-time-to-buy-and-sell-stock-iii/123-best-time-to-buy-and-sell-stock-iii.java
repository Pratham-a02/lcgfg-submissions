class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][3][2];
        for(int[][]d:dp){
            for(int[]d1:d){
                Arrays.fill(d1,-1);
            }
        }
        return bestTime(0,prices,2,1,dp);
    }
    public int bestTime(int currDay,int[] prices,int transCount,int canBuy,int[][][] dp){
        if(currDay>= prices.length || transCount == 0){
            return 0;
        }
        
        if(dp[currDay][transCount][canBuy] != -1){
            return dp[currDay][transCount][canBuy];
        }
        
        if(canBuy == 1){
            int idle = bestTime(currDay+1,prices,transCount,1,dp);
            int buy = -prices[currDay] + bestTime(currDay+1,prices,transCount,0,dp);
            return dp[currDay][transCount][canBuy] = Math.max(idle,buy);
        }
        else{
            int idle = bestTime(currDay+1,prices,transCount,0,dp);
            int sell = prices[currDay] + bestTime(currDay+1,prices,transCount-1,1,dp);
            return dp[currDay][transCount][canBuy] = Math.max(idle,sell);
        }
    }
}