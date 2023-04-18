class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return permutation_Infinite(nums,target,dp);
    }
    
    public static int permutation_Infinite(int[] coins,int target,int[] dp){
        if(target == 0){
            return dp[target] = 1;
        }

        if(dp[target] != -1){
            return dp[target];
        }
        int count = 0;

        for(int i = 0;i<coins.length;i++){
            if(target >= coins[i]){
                count += permutation_Infinite(coins,target-coins[i],dp);
            }
        }

        return dp[target] = count;
    }
}