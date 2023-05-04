class Solution{
    public int longestPalindromeSubseq(String s){
        int[][] dp = new int[1001][1001];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return lps(0,s.length()-1,s,dp);
    }
    
    public int lps(int i,int j,String s,int[][] dp){
        if(i>j){
            return 0;
        }
        if(i == j)return 1;
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = lps(i+1,j-1,s,dp)+2;
        }
        else{
            return dp[i][j] = Math.max(lps(i+1,j,s,dp),lps(i,j-1,s,dp));
        }
    }
}