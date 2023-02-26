class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[501][501];
        for(int[]arr:dp){
            Arrays.fill(arr,-1);
        }
        return minOps(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
    
    public int minOps(int i,int j,String word1,String word2,int[][] dp){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = minOps(i-1,j-1,word1,word2,dp);
        }
        else{
            return dp[i][j] = Math.min(1+minOps(i-1,j,word1,word2,dp),Math.min(1+minOps(i,j-1,word1,word2,dp),1+minOps(i-1,j-1,word1,word2,dp)));
        }
    }
}