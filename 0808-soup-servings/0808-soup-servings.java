class Solution{
    int[][] dirs = {{100,0},{75,25},{50,50},{25,75}};
    public double soupServings(int n){
        if(n>=5000)return 1.0;
        double[][] dp = new double[n+1][n+1];
        for(double[] d:dp){
            Arrays.fill(d,-1.0);
        }
        return solve(n,n,dp);
    }
    
    public double solve(int A,int B,double[][] dp){
        if(A<=0 && B<=0) return 0.5;

        if(A<=0) return 1.0;
        
        if(B<=0) return 0.0;
        
        if(dp[A][B] != -1.0){
            return dp[A][B];
        }
        
        double count = 0.0;
        
        for(int[] dir:dirs){
            int A_taken = dir[0];
            int B_taken = dir[1];
            
            count += solve(A-A_taken,B-B_taken,dp);
        }
        
        return dp[A][B] = count*0.25;
    }
}