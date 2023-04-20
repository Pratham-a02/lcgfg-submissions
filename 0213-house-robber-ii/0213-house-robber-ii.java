class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 0 || n == 1){
            return (n == 1)?nums[0]:0;
        }
        
        int[] dp1 = new int[n+1];
        Arrays.fill(dp1,-1);
        
        int ans1 = rob(0,n-2,nums,dp1);
        
        int[] dp2 = new int[n+1];
        Arrays.fill(dp2,-1);
        
        int ans2 = rob(1,n-1,nums,dp2);
        
        return Math.max(ans1,ans2);
    }
    
    public int rob(int currIdx,int n,int[] nums,int[] dp){
        if(currIdx>n){
            return 0;
        }
        
        if(dp[currIdx] != -1){
            return dp[currIdx];
        }
        
        int rob = nums[currIdx] + rob(currIdx+2,n,nums,dp);
        int noRob = rob(currIdx+1,n,nums,dp);
        
        return dp[currIdx] = Math.max(rob,noRob);
    }
}