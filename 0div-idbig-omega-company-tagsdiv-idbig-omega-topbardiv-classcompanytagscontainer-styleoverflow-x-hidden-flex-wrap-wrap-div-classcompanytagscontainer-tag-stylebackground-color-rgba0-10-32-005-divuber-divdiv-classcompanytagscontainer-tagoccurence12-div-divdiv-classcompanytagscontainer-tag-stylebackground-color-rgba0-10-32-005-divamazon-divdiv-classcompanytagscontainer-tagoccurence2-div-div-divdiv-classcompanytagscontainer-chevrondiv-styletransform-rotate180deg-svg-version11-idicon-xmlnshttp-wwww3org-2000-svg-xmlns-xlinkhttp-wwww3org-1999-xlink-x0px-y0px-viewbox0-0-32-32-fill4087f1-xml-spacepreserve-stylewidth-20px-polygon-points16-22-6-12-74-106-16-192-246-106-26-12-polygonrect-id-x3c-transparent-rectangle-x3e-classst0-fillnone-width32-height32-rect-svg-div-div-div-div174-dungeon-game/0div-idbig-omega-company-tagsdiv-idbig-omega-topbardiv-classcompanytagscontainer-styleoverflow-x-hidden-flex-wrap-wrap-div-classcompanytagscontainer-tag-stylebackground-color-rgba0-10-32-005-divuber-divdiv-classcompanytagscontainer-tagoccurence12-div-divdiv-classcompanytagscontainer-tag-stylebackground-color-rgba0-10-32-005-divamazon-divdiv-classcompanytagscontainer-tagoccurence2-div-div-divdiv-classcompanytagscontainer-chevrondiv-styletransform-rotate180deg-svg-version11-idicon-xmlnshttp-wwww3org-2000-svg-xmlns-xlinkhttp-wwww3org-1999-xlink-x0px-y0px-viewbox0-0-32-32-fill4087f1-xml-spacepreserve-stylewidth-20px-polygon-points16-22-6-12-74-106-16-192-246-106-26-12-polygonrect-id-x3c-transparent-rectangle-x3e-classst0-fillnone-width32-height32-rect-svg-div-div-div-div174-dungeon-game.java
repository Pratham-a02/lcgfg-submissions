class Solution{
    public int calculateMinimumHP(int[][] dungeon){
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 0;
        }
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,0,dungeon,dp);
    }
    
    public int solve(int i,int j,int[][] dungeon,int[][] dp){
        if(i>=dungeon.length || j>=dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int health = Math.min(solve(i+1,j,dungeon,dp),solve(i,j+1,dungeon,dp));
        
        if(health == Integer.MAX_VALUE){
            health = 1;
        }
        
        int res = 0;
        if(health - dungeon[i][j]>0){
            res = health - dungeon[i][j];
        }
        else{
            res = 1;
        }
        
        return dp[i][j] = res;
    }
}