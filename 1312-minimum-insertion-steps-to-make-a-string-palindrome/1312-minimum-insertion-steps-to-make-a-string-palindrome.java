class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[501][501];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        int lps = LPS(0,s.length()-1,s,dp);
        return s.length() - lps;
    }
    
    public int LPS(int i,int j,String s,int[][] dp){
        if(i>j){
            return dp[i][j] = 0;
        }
        
        if(i == j){
            return dp[i][j] = 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = LPS(i+1,j-1,s,dp) + 2;
        }
        else{
            return dp[i][j] = Math.max(LPS(i+1,j,s,dp),LPS(i,j-1,s,dp));
        }
    }
}