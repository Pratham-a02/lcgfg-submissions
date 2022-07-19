class Solution {
    public int maxProfit(int[] prices) {
         int[][][] dp = new int[prices.length][2][3];
        for(int i=0 ;i<prices.length ;i++){
            for(int j=0; j<2;j++){
                for(int k=0 ;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return bestTime(prices,0,1,2,dp);
    }
    
    public int bestTime(int[] prices,int currDay,int canBuy,int transCount,int[][][]dp){
        if(currDay>=prices.length || transCount<=0)
            return 0;
        if(dp[currDay][canBuy][transCount]!= -1)
            return dp[currDay][canBuy][transCount];
        
        if(canBuy == 1){
            int idle = bestTime(prices,currDay+1,canBuy,transCount,dp);
            int buy = -prices[currDay] + bestTime(prices,currDay+1,0,transCount,dp);    
            return dp[currDay][canBuy][transCount] = Math.max(idle,buy);
        }
        else{
            int idle = bestTime(prices,currDay+1,canBuy,transCount,dp);
            int sell = prices[currDay] + bestTime(prices,currDay+1,1,transCount-1,dp);
            return dp[currDay][canBuy][transCount] = Math.max(idle,sell);
        }
    }
}