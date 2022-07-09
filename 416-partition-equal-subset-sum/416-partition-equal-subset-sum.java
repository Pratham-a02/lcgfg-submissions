class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }
        int[][] dp = new int[N+1][sum+1];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        if(sum%2 != 0){
            return false;
        }
        int w = isPossible(0,nums,sum/2,N,dp);
        if(w == 1)
            return true;
        return false;
    }
    
    public int isPossible(int currIdx,int[] nums,int sum,int N,int[][] dp){
        if(currIdx>= nums.length){
            return 0;
        }
        if(sum == 0)
            return 1;
        if(nums.length == 0)
            return 0;
        if(dp[currIdx][sum] != -1)
            return dp[currIdx][sum];
        int taken = 0;
        if(nums[currIdx]<= sum)
            taken = isPossible(currIdx+1,nums,sum-nums[currIdx],N,dp);
        int notTaken = isPossible(currIdx+1,nums,sum,N,dp);
        
        if(taken == 1 || notTaken == 1)
            return dp[currIdx][sum] = 1;
        return dp[currIdx][sum] = 0;
    }
}