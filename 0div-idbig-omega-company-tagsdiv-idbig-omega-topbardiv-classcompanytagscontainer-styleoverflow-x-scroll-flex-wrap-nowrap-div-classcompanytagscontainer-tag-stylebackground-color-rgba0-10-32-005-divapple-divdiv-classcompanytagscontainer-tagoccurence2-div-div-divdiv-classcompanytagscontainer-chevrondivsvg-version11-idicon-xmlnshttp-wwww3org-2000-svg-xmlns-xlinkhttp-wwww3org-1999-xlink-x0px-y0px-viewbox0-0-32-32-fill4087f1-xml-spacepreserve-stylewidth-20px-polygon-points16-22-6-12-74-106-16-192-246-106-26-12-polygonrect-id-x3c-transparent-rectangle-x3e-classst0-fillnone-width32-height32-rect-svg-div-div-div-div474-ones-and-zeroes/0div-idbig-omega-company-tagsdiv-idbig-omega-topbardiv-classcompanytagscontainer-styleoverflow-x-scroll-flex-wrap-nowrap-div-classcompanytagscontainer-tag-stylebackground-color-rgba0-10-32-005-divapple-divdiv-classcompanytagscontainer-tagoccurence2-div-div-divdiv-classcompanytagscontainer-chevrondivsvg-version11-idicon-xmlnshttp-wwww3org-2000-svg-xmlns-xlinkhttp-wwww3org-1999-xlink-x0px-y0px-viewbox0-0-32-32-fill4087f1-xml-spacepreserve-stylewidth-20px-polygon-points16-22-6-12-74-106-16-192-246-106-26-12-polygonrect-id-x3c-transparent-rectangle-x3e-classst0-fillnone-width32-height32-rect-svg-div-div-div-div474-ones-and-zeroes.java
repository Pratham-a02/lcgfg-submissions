class Solution{
    public int findMaxForm(String[] strs,int m,int n){
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int[][]d:dp){
            for(int[]d1:d){
                Arrays.fill(d1,-1);
            }
        }
        return solve(0,m,n,strs,dp);
    }
    
    public int solve(int idx,int m,int n,String[] strs,int[][][] dp){
        if(idx >= strs.length || m+n == 0){
            return 0;
        }
        
        if(dp[idx][m][n] != -1){
            return dp[idx][m][n];
        }
        
        String str = strs[idx];
        int zc = 0;
        int oc = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '0') zc++;
            else if(ch == '1') oc++;
        }
        int taken = 0;
        if(zc <= m && oc <= n){
            taken = 1 + solve(idx+1,m-zc,n-oc,strs,dp);
        }
        int noTaken = solve(idx+1,m,n,strs,dp);
        
        return dp[idx][m][n] = Math.max(taken,noTaken);
    }
}