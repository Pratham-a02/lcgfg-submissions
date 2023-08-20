class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if(nums.size()<=2){
            return true;
        }
        int n = nums.size();
        int[][] dp = new int[n+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int totalSum = 0;
        for(int num:nums){
            totalSum += num;
        }
        return solve(0,nums.size()-1,m,nums,totalSum,dp);
    }
    
    public boolean solve(int start,int end,int m,List<Integer> nums,int totalSum,int[][] dp){
        if(start == end){
            return true;
        }
        
        if(totalSum < m){
            return false;
        }
        
        if(dp[start][end] != -1){
            return dp[start][end] == 1;
        }
        
        boolean ans = solve(start+1,end,m,nums,totalSum - nums.get(start),dp) || solve(start,end-1,m,nums,totalSum-nums.get(end),dp);
        
        dp[start][end] = (ans == true)?1:0;
        return ans;
    }
}