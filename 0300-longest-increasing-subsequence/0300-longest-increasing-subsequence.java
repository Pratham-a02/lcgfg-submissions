class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // int len = 0;
        // for(int i = 0;i<nums.length;i++){
        //     len = Math.max(len,LIS_R(i,nums,dp));
        // }
        return LIS_Tab(nums,dp);
    }
    
    public int LIS_R(int i,int[] nums,int[] dp){
        if(dp[i]!=0){
            return dp[i];
        }
        int longestLen = 1;
        for(int j = i+1;j<nums.length;j++){
            if(nums[i]<nums[j]){
                int len = 1 + LIS_R(j,nums,dp);
                longestLen = Math.max(len,longestLen);
            }
        }
        
        return dp[i] = longestLen;
    }
    
    public int LIS_Tab(int[] nums,int[] dp){
        int len = 0;
        for(int i = 0;i<nums.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            len = Math.max(len,dp[i]);
        }
        return len;
    }
}