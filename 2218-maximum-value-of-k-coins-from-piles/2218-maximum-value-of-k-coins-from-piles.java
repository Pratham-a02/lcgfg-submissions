class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()+1][k+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        
        return solve(piles,k,0,dp);
    }
    
    public int solve(List<List<Integer>> piles,int k,int idx,int[][] dp){
        if(idx>=piles.size() || k == 0){
            return 0;
        }
        
        if(dp[idx][k] != -1){
            return dp[idx][k];
        }
        
        int max = 0;
        max = Math.max(max,solve(piles,k,idx+1,dp));
        int val = 0;
        for(int j = 0;j<Math.min(piles.get(idx).size(),k);j++){
            
                val += piles.get(idx).get(j);
                max = Math.max(max,val + solve(piles,k-j-1,idx+1,dp));
            
        }
        return dp[idx][k] = max;
    }
}