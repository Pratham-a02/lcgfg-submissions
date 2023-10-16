class Solution{
    public int maxSizeSlices(int[] slices){
        int n = slices.length;
        int[][] dp1 = new int[n+1][n+1];
        for(int[]d:dp1){
            Arrays.fill(d,-1);
        }
        int[][] dp2 = new int[n+1][n+1];
        for(int[]d:dp2){
            Arrays.fill(d,-1);
        }
        return Math.max(solve(0,slices.length-2,slices,n/3,dp1),solve(1,slices.length-1,slices,n/3,dp2));
    }
    
    public int solve(int idx,int endIdx,int[] slices,int slice,int[][] dp){
        if(slice == 0 || idx>endIdx){
            return 0;
        }
        
        if(dp[idx][slice] != -1){
            return dp[idx][slice];
        }
        
        int taken = slices[idx] + solve(idx+2,endIdx,slices,slice-1,dp);
        int noTaken = solve(idx+1,endIdx,slices,slice,dp);
        
        return dp[idx][slice] = Math.max(taken,noTaken);
    }
}