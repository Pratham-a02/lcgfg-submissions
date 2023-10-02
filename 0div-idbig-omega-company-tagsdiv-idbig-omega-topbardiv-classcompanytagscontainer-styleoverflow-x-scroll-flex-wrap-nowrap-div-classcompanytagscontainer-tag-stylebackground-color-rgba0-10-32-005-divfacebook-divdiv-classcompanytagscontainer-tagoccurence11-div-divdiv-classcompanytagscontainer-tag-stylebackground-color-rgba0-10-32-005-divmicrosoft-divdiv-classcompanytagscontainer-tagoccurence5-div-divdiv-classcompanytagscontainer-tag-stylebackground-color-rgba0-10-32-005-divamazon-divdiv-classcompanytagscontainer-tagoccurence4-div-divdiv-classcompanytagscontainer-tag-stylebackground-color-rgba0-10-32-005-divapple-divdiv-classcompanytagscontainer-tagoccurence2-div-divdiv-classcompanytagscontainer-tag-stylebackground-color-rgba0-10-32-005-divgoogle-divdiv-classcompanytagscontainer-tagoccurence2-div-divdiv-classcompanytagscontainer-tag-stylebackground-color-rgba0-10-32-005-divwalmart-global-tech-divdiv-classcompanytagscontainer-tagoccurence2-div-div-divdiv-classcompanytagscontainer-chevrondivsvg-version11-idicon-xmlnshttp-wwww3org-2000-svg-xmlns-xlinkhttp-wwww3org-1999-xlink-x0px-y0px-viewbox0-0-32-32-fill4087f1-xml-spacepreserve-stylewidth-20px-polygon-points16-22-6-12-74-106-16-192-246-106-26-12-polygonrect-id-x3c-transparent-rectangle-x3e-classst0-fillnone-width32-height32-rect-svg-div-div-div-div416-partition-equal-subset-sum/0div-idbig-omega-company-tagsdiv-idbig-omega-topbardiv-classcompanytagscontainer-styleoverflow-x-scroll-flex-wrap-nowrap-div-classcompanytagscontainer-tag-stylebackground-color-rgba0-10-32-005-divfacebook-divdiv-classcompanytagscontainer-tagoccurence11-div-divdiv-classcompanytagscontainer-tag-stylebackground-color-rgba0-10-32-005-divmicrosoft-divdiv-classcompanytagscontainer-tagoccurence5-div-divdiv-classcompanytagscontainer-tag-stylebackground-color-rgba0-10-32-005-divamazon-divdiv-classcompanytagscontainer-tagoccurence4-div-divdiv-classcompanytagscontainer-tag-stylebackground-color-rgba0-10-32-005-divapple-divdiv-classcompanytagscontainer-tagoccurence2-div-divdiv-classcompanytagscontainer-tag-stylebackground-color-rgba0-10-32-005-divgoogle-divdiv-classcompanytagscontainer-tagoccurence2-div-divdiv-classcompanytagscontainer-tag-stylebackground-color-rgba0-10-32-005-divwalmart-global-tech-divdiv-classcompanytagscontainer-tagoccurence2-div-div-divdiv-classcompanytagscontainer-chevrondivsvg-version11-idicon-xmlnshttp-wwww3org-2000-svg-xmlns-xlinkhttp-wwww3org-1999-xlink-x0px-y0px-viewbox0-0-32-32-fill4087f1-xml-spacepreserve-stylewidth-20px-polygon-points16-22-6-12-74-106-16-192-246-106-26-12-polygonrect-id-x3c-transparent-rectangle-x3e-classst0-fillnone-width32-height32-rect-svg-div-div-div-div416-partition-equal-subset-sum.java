class Solution{
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum%2 == 1) return false;
        int[][] dp = new int[nums.length+1][sum+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int ans = solve(0,sum/2,nums,dp);
        if(ans == 1) return true;
        else return false;
    }
    
    public int solve(int idx,int sum,int[] nums,int[][] dp){
        if(sum == 0) return dp[idx][sum] = 1;
        
        if(idx>=nums.length && sum != 0) return dp[idx][sum] = 0;
        
        if(dp[idx][sum] != -1) return dp[idx][sum];
        
        int taken = 0;
        if(sum - nums[idx]>=0){
            taken = solve(idx+1,sum-nums[idx],nums,dp);
        }
        int noTaken = solve(idx+1,sum,nums,dp);
        
        if(taken == 1 || noTaken == 1){
            return dp[idx][sum] = 1;
        }
        else{
            return dp[idx][sum] = 0;
        }
    }
}