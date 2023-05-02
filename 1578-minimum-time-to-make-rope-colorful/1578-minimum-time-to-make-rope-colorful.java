class Solution {
    public int minCost(String colors, int[] neededTime){
        int[][] dp = new int[colors.length()+1][27];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return solve(colors.length()-1,colors,neededTime,'{',dp);
    }
    
    public int solve(int idx,String colors,int[] need,char prev,int[][] dp){
        if(idx == 0){
            if(prev == colors.charAt(idx)){
                return dp[idx][prev-'a'] = need[idx];
            }
            return dp[idx][prev-'a'] = 0;
        }
        
        if(dp[idx][prev-'a'] != -1){
            return dp[idx][prev-'a'];
        }
        
    
         int taken = need[idx] + solve(idx-1,colors,need,prev,dp);
        int notTaken = (int)1e9;
        
        if(colors.charAt(idx) != prev){
            notTaken = solve(idx-1,colors,need,colors.charAt(idx),dp);
        }
        
        
        
        return dp[idx][prev-'a'] = Math.min(taken,notTaken);
    }
    
    
}