class Solution{
    public int strangePrinter(String s){
        int[][] dp = new int[101][101];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,s.length()-1,s,dp);
    }
    
    public int solve(int i,int j,String s,int[][] dp){
        if(i == j){
            return 1;
        }
        if(i>j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int minTurn = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            minTurn = Math.min(minTurn,solve(i,k,s,dp)+solve(k+1,j,s,dp));
        }
        
        if(s.charAt(i) == s.charAt(j)){
            minTurn--;
        }
        
        return dp[i][j] = minTurn;
    }
}