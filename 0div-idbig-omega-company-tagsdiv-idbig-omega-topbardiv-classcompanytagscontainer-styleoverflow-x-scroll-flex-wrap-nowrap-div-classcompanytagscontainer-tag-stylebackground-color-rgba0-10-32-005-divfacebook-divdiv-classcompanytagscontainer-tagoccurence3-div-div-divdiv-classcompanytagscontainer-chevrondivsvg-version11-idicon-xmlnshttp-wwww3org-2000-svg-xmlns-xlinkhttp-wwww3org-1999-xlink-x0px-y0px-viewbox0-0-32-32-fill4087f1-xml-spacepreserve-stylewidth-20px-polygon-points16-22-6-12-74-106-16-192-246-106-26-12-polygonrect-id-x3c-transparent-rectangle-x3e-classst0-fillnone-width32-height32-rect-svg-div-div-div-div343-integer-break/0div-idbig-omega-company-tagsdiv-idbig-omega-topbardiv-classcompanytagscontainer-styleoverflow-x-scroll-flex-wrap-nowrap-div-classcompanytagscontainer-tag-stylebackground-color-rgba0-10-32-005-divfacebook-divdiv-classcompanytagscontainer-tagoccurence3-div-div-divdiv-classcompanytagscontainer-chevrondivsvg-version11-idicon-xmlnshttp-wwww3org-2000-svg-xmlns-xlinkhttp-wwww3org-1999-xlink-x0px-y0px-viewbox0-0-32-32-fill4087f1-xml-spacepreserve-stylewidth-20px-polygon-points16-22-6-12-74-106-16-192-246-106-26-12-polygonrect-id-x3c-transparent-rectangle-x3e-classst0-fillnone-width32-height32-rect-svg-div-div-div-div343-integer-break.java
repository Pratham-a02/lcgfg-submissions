class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    
    public int solve(int n,int[] dp){
        if(n==1){
            return 1;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        int result = Integer.MIN_VALUE;
        for(int i = 1;i<n;i++){
            int prod = i*Math.max(n-i,solve(n-i,dp));
            
            result = Math.max(result,prod);
        }
        
        return dp[n] = result;
    }
}