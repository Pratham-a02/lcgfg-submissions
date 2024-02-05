class Solution{
    public int minDistance(String word1,String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        int lcs = solve(m,n,word1,word2,dp);
        return (m-lcs) + (n-lcs);
    }
    
    public int solve(int i,int j,String word1,String word2,int[][] dp){
        if(i == 0 || j == 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(word1.charAt(i-1) == word2.charAt(j-1)){
            dp[i][j] = 1 + solve(i-1,j-1,word1,word2,dp);
        }
        else{
            dp[i][j] = Math.max(solve(i-1,j,word1,word2,dp),solve(i,j-1,word1,word2,dp));
        }
        
        return dp[i][j];
    }
}