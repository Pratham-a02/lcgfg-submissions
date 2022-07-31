class Solution {
    public int lengthOfLIS(int[] nums) {
        int worstSize = 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int max = 0;
        for(int i = 0;i<dp.length;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}