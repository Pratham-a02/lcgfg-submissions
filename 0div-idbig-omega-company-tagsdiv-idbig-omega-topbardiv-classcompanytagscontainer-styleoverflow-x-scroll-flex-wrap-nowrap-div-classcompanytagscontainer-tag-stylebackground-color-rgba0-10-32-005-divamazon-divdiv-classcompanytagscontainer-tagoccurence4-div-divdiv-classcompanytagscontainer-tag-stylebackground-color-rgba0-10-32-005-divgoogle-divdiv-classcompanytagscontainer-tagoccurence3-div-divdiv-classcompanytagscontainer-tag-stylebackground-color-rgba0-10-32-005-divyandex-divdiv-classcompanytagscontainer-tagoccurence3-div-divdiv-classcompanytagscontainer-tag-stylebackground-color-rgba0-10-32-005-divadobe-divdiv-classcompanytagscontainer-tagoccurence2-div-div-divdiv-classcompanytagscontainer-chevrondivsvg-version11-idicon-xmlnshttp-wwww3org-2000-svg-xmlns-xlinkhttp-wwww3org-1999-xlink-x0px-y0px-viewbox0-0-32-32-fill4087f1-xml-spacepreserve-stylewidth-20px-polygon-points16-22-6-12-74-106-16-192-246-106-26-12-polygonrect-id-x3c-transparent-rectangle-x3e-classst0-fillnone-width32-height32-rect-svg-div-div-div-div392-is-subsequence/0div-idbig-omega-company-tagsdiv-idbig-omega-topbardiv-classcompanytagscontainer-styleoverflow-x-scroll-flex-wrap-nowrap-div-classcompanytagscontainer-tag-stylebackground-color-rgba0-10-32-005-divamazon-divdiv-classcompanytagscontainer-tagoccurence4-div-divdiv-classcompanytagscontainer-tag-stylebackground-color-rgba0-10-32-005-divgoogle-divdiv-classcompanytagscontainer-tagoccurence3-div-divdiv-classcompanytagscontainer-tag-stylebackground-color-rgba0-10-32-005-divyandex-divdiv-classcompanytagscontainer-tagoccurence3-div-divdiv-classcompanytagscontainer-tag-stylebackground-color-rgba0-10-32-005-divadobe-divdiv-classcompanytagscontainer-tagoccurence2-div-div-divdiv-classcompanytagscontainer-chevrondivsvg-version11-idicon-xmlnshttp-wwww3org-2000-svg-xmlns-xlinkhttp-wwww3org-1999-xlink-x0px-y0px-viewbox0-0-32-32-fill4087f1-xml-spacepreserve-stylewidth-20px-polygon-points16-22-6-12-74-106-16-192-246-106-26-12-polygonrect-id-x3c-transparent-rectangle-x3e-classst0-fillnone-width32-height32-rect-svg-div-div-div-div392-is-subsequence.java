class Solution{
    public boolean isSubsequence(String s, String t){
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        
        int ans = lcs(s.length(),t.length(),s,t,dp);
        if(ans == s.length()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int lcs(int m,int n,String s,String t,int[][] dp){
        if(m == 0 && n == 0){
            return dp[m][n] = 0;
        }
        if(m == 0 || n == 0){
            return dp[m][n] = 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(s.charAt(m-1) == t.charAt(n-1)){
            return dp[m][n] =  1 + lcs(m-1,n-1,s,t,dp);
        }
        else{
            return dp[m][n] = Math.max(lcs(m-1,n,s,t,dp),lcs(m,n-1,s,t,dp));
        }
    }
}