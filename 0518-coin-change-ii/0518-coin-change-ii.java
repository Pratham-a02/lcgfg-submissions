class Solution {
    public int change(int Target, int[] coins) {
        int[] dp = new int[Target+1];
        dp[0] = 1;
        for(int ele:coins){
            for(int target = ele;target<=Target;target++){
                if(target >= ele){
                    dp[target] += dp[target-ele];//permutation_Infinite(coins,target-coins[i],dp);
                }
            }
        }
        return dp[Target];
    }
}