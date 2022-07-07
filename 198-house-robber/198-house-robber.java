class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp,-1);
        return HouseRob(nums,0,dp);
    }
    public int HouseRob(int[] nums,int currIdx,int[] dp){
        if(currIdx >= nums.length)
            return 0;
        if(dp[currIdx]!= -1)
            return dp[currIdx];
        int rob = nums[currIdx] + HouseRob(nums,currIdx + 2,dp);
        int noRob = HouseRob(nums, currIdx + 1,dp);
        
        dp[currIdx] = Math.max(rob,noRob);
        return dp[currIdx];
    }
}