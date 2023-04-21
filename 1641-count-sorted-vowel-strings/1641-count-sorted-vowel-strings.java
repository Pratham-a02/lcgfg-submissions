class Solution {
    public int countVowelStrings(int n){
        if(n == 1){
            return 5;
        }
        int[][] dp = new int[n+1][5];
        return solve(0,n,dp);
    }
    
    public int solve(int i,int n,int[][] dp){
        if(n == 0){
            return dp[n][i] = 1;
        }
        
        if(dp[n][i] != 0){
            return dp[n][i];
        }
        
        int count = 0;
        for(int j = i;j<5;j++){
            count += solve(j,n-1,dp);
        }
        return dp[n][i] = count;
    }
}