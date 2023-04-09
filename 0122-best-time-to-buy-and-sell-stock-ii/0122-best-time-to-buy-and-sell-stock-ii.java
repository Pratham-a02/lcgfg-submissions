class Solution {
    public int maxProfit(int[] prices){
        int[][] dp = new int[prices.length+1][2];
        for(int[] arr1:dp){
            Arrays.fill(arr1,-1);
        }
        return max(0,1,prices,dp);
    }
    
    public int max(int currIdx,int canBuy,int[] prices,int[][] dp){
        if(currIdx>=prices.length){
            return 0;
        }
        
        if(dp[currIdx][canBuy] != -1){
            return dp[currIdx][canBuy];
        }
        
        if(canBuy == 1){
            int idle = max(currIdx+1,1,prices,dp);
            int buy = -prices[currIdx] + max(currIdx+1,0,prices,dp);
            return dp[currIdx][canBuy] = Math.max(idle,buy);
        }
        else{
            int idle = max(currIdx+1,0,prices,dp);
            int sell = prices[currIdx] + max(currIdx+1,1,prices,dp);
            
            return dp[currIdx][canBuy] = Math.max(idle,sell);
        }
    }
}