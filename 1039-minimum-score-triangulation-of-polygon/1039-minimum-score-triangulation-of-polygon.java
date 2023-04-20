class Solution{
    public int minScoreTriangulation(int[] values){
        int n = values.length;
        int[][] dp = new int[n][n];
        return minScore(0,n-1,values,dp);
    }
    
    public int minScore(int si,int ei,int[] arr,int[][] dp){
        if(ei - si <=1){
            return dp[si][ei] = 0;
        }
        
        if(dp[si][ei] != 0){
            return dp[si][ei];
        }
        
        int minAns = (int)1e9;
        for(int cut = si+1;cut<ei;cut++){
            int left = minScore(si,cut,arr,dp);
            int right = minScore(cut,ei,arr,dp);
            
            minAns = Math.min(minAns,left + arr[si]*arr[cut]*arr[ei] + right);
        }
        
        return dp[si][ei] = minAns;
    }
}