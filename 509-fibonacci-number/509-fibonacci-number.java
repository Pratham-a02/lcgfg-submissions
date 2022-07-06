class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fibM(n,dp);
    }
    public static int fibM(int n,int[] dp){
        if(n<=1)
            return dp[n] = n;
        if(dp[n]!= -1)
            return dp[n];
        
        int nm1 = fibM(n-1,dp);
        int nm2 = fibM(n-2,dp);
        dp[n] = nm1+nm2;
        return dp[n];
    }
}