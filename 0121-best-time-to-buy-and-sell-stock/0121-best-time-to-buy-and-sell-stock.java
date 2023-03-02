class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][2];
        for(int[][] arr1:dp){
            for(int[] arr2:arr1){
                Arrays.fill(arr2,-1);
            }
        }
        return getMax(0,1,1,prices,dp);
    }
    
    public int getMax(int currIdx,int trans,int canBuy,int[] prices,int[][][] dp){
        if(currIdx>=prices.length || trans == 0){
            return 0;
        }
        
        if(dp[currIdx][trans][canBuy] != -1){
            return dp[currIdx][trans][canBuy];
        }
        
        if(canBuy == 1){
            int idle = getMax(currIdx+1,trans,1,prices,dp);
            int buy = -prices[currIdx] + getMax(currIdx+1,trans,0,prices,dp);
            
            return dp[currIdx][trans][canBuy] = Math.max(idle,buy);
        }
        else{
            int idle = getMax(currIdx+1,trans,0,prices,dp);
            int sell = prices[currIdx] + getMax(currIdx+1,trans-1,1,prices,dp);
            return dp[currIdx][trans][canBuy] = Math.max(idle,sell);
        }
    }
}