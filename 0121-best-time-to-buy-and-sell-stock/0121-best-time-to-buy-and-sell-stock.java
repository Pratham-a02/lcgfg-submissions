class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][2];
        for(int[][] arr:dp){
            for(int[] arr1:arr)
                Arrays.fill(arr1,-1);
        }
        return getMax(0,1,1,prices,dp);
    }
    
    public int getMax(int idx,int canBuy,int count,int[] prices,int[][][] dp){
        if(idx>=prices.length){
            return 0;
        }
        if(count == 0){
            return 0;
        }
        
        if(dp[idx][count][canBuy] != -1){
            return dp[idx][count][canBuy];
        }
        
        if(canBuy == 1){
            int idle = getMax(idx+1,1,count,prices,dp);
            int buy = -prices[idx] + getMax(idx+1,0,count,prices,dp);
            return dp[idx][count][canBuy] = Math.max(idle,buy);
        }
        else{
            int idle  = getMax(idx+1,0,count,prices,dp);
            int sell = prices[idx] + getMax(idx+1,1,count-1,prices,dp);
            return dp[idx][count][canBuy] = Math.max(idle,sell);
        }
    }
}