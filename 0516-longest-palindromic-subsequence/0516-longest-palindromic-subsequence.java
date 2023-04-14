class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        
        return lps(s,0,s.length()-1,dp);
    }
    
    public int lps(String s,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(i == j){
            return 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = lps(s,i+1,j-1,dp) + 2;
        }
        else{
            return dp[i][j] = Math.max(lps(s,i+1,j,dp),lps(s,i,j-1,dp));
        }
    }
}