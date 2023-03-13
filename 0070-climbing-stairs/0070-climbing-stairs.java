class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return totalWays(0,n,dp);
    }
    
    public int totalWays(int curr,int n,int[] dp){
        if(curr == n){
            return 1;
        }
        if(curr>n){
            return 0;
        }
        if(dp[curr] != 0){
            return dp[curr];
        }
        int count = 0;
        
        count += totalWays(curr+1,n,dp);
        count += totalWays(curr+2,n,dp);
        
        return dp[curr] = count;
    }
}