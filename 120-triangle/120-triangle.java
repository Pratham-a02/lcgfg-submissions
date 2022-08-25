class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[201][201];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return minSum(0,0,triangle,dp);
    }
    public int minSum(int row,int col,List<List<Integer>> triangle,int[][] dp){
        if(row == triangle.size()){
            return 0;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        return dp[row][col] = Math.min(triangle.get(row).get(col) + minSum(row+1,col,triangle,dp),triangle.get(row).get(col) + minSum(row+1,col+1,triangle,dp));
        
    }
}