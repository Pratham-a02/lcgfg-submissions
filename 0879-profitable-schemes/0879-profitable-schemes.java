class Solution {
    int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[110][110][110];
        for(int[][]d:dp){
            for(int[]d1:d){
                Arrays.fill(d1,-1);
            }
        }
        return totalSchemes(0,n,minProfit,group,profit,dp)%mod;
    }
    
    public int totalSchemes(int idx,int n,int minProfit,int[] group,int[] profit,int[][][] dp){
        if(n<0){
            return 0;
        }
        
        if(idx>= group.length){
            
            if(minProfit > 0){
                return 0;
            }
            else{
                return 1;
            }
        }
        
        if(minProfit < 0)   minProfit = 0;
        
        if(dp[idx][n][minProfit] != -1){
            return dp[idx][n][minProfit];
        }
        
        int taken = totalSchemes(idx+1,n-group[idx],minProfit-profit[idx],group,profit,dp);
        int notTaken = totalSchemes(idx+1,n,minProfit,group,profit,dp);
        
        return dp[idx][n][minProfit] = (taken+notTaken)%mod;
    }
}