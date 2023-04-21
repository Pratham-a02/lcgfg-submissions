class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        return maxSum(0,arr,k,dp);
    }
    
    public int maxSum(int idx,int[] arr,int k,int[] dp){
        if(idx == arr.length){
            return dp[idx] = 0;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int maxAns = Integer.MIN_VALUE;
        
        int len = 0;
        int currMax = Integer.MIN_VALUE;
        
        for(int j = idx;j<Math.min(arr.length,idx+k);j++){
            len++;
            currMax = Math.max(currMax,arr[j]);
            int sum = len*currMax + maxSum(j+1,arr,k,dp);
            maxAns = Math.max(maxAns,sum);
        }
        return dp[idx] = maxAns;
    }
}