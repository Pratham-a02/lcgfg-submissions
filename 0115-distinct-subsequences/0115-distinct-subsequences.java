class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        
        return numDistinct_M(s,t,n,m,dp);
    }
    
    public int numDistinct_M(String s, String t,int n,int m,int[][] dp) {
        if(m == 0){
            return dp[n][m] = 1;
        }
        if(n<m){
            return dp[n][m] = 0;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        if(s.charAt(n-1) == t.charAt(m-1)){
            dp[n][m] = numDistinct_M(s,t,n-1,m-1,dp) + numDistinct_M(s,t,n-1,m,dp);
        }
        else{
            dp[n][m] = numDistinct_M(s,t,n-1,m,dp);
        }
        
        return dp[n][m];
    }
}