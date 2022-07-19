class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][3][2];
        for(int i = 0;i<prices.length;i++){
            for(int j = 0;j<3;j++){
                for(int k = 0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return bestTime(0,1,1,prices,dp);
    }
    public int bestTime(int currDay,int transCount,int canBuy,int[] prices,int[][][] dp){
        if(currDay>=prices.length || transCount<=0)
            return 0;
        if(dp[currDay][transCount][canBuy]!= -1)
            return dp[currDay][transCount][canBuy];
        
        if(canBuy == 1){
            int idle = bestTime(currDay+1,transCount,canBuy,prices,dp);
            int buy = -prices[currDay] + bestTime(currDay+1,transCount,0,prices,dp);
            return dp[currDay][transCount][canBuy] = Math.max(idle,buy);
        }
        else{
            int idle = bestTime(currDay+1,transCount,canBuy,prices,dp);
            int sell = prices[currDay] + bestTime(currDay+1,transCount-1,1,prices,dp);
            return dp[currDay][transCount][canBuy] = Math.max(idle,sell);
        }
    }
}