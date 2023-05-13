class Solution{
    
    public int countGoodStrings(int low,int high,int zero,int one){
        int[] dp = new int[100001];
        Arrays.fill(dp,-1);
        int ans = solve(0,low,high,zero,one,dp);
        return ans%1000000007;
    }
    
    public int solve(int len,int lo,int hi,int zero,int one,int[] dp){
        if(len>hi){
            return 0;
        }
        
        if(dp[len] != -1){
            return dp[len];
        }
        
        int zer = solve(len+zero,lo,hi,zero,one,dp);
        int on = solve(len+one,lo,hi,zero,one,dp);
        
        if(len >= lo && len <= hi){
            return dp[len] = (zer + on + 1)%1000000007;
        }
        else{
            return dp[len] = (zer+on)%1000000007;
        }
    }
}