class Solution{
    public double largestSumOfAverages(int[] nums,int k){
        int n = nums.length;
        double[][] dp = new double[n+1][n+1];
        for(double[]d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,nums.length-1,k,nums,dp);
    }
    
    public double solve(int i,int j,int k,int[] nums,double[][] dp){
        if(i>j || k<=0){
            if(i == nums.length && k == 0){
                return 0;
            }
            else{
                return Integer.MIN_VALUE/2;
            }
        }
        
        if(dp[i][k] != -1){
            return dp[i][k];
        }
        
        double temp = Integer.MIN_VALUE/2;
        int sum = 0;
        for(int c = i;c<=j;c++){
            sum += nums[c];
            double avg = (sum*1.0)/(c-i+1);
            temp = Math.max(temp,avg+solve(c+1,j,k-1,nums,dp));
        }
        
        return dp[i][k] = temp;
    }
}