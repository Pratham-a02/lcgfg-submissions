class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return totalWays(n,dp);
    }
    public int totalWays(int n,int[] dp){
        if(n<=1)
            return 1;
        
        if(dp[n] != -1)
            return dp[n];
        
        int count = 0;
        for(int i = 0;i<n;i++){
            count += totalWays(i,dp) * totalWays(n-i-1,dp);
        }
        return dp[n] = count;
    }
}