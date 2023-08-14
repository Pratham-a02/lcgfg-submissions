class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] dp = new Boolean[nums.length+1];
        return solve(0,nums,dp);
    }
    
    public boolean solve(int idx,int[] nums,Boolean[] dp){
        if(idx == nums.length)
            return true;
        
        if(dp[idx] != null){
            return dp[idx];
        }
        boolean res = false;
        
        if(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            res |= solve(idx+2,nums,dp);
        }
        if(idx+2 < nums.length && nums[idx] == nums[idx+1] && nums[idx] == nums[idx+2]){
            res |= solve(idx+3,nums,dp);
        }
        if(idx+2<nums.length && nums[idx]+1 == nums[idx+1] && nums[idx]+2 == nums[idx+2]){
            res |= solve(idx+3,nums,dp);
        }
        return dp[idx] = res;
    }
}