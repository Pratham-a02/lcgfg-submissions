class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int i = 0;i<nums.length;i++){
            len = Math.max(len,LIS_R(i,nums,dp));
        }
        return len;
    }
    
    public int LIS_R(int i,int[] nums,int[] dp){
        if(dp[i]!=0){
            return dp[i];
        }
        int longestLen = 1;
        for(int j = i-1;j>=0;j--){
            if(nums[j]<nums[i]){
                int len = 1 + LIS_R(j,nums,dp);
                longestLen = Math.max(len,longestLen);
            }
        }
        
        return dp[i] = longestLen;
    }
}