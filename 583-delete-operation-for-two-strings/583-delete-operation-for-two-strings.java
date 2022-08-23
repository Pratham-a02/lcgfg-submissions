class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        int lcs = Lcs(0,0,word1,word2,dp);
        return (word1.length()-lcs) + (word2.length()-lcs);
    }
    
    public int Lcs(int currIdx1,int currIdx2,String word1,String word2,int[][] dp){
        if(currIdx1>=word1.length() || currIdx2>=word2.length()){
            return 0;
        }
        if(dp[currIdx1][currIdx2] != -1){
            return dp[currIdx1][currIdx2];
        }
        if(word1.charAt(currIdx1) == word2.charAt(currIdx2)){
            dp[currIdx1][currIdx2] =  1 + Lcs(currIdx1+1,currIdx2+1,word1,word2,dp);
        }
        else{
            dp[currIdx1][currIdx2] =      Math.max(Lcs(currIdx1+1,currIdx2,word1,word2,dp),Lcs(currIdx1,currIdx2+1,word1,word2,dp));
        }
        return dp[currIdx1][currIdx2];
    }
}