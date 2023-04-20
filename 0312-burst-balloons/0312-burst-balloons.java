class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        return bb_R(0,nums.length-1,nums,dp);
    }
    
    public int bb_R(int si,int ei,int[] nums,int[][] dp){
        if(si>ei){
            return 0;
        }
        
        if(dp[si][ei] != 0){
            return dp[si][ei];
        }
        
        int lele = (si == 0)?1:nums[si-1];
        int rele = (ei == nums.length-1)?1:nums[ei+1];
        int max = 0;
        
        for(int cut = si;cut<=ei;cut++){
            int left = bb_R(si,cut-1,nums,dp);
            int right = bb_R(cut+1,ei,nums,dp);
            
            max = Math.max(max,left + lele*nums[cut]*rele + right);
        }
        
        return dp[si][ei] = max;
    }
}