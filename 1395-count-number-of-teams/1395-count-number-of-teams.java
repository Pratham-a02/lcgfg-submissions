class Solution{
    public int numTeams(int[] rating){
        int[][] dp = new int[1001][4];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        int ans1 = 0;
        for(int idx = 0;idx<rating.length;idx++){
            ans1 += solve1(idx,0,rating,3,dp);
        }
        
        int[][] dp1 = new int[1001][4];
        for(int[]d:dp1){
            Arrays.fill(d,-1);
        }
        int ans2 = 0;
        for(int idx = 0;idx<rating.length;idx++){
            ans2 += solve2(idx,0,rating,3,dp1);
        }
        
        return ans1+ans2;
    }
    
    public int solve1(int idx,int len,int[] rating,int k,int[][] dp){
        if(len == k-1){
            return 1;
        }
        
        if(dp[idx][len] != -1){
            return dp[idx][len];
        }
        
        int count = 0;
        for(int j = idx+1;j<rating.length;j++){
            if(rating[idx]<rating[j]){
                count += solve1(j,len+1,rating,k,dp);
            }
        }
        return dp[idx][len] = count;
    }
    
    public int solve2(int idx,int len,int[] rating,int k,int[][] dp){
        if(len == k-1){
            return 1;
        }
        
        if(dp[idx][len] != -1){
            return dp[idx][len];
        }
        
        int count = 0;
        for(int j = idx+1;j<rating.length;j++){
            if(rating[idx]>rating[j]){
                count += solve2(j,len+1,rating,k,dp);
            }
        }
        return dp[idx][len] = count;
    }
    
}