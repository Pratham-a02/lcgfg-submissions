class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid[0].length;
        int ans = 0;
        int[][] mat = new int[n][2];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                mat[i][0] = Math.max(mat[i][0],grid[j][i]);
                mat[i][1] = Math.max(mat[i][1],grid[i][j]);
            }
            System.out.println(mat[i][0] + " " + mat[i][1]);
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                int min = Math.min(mat[j][0],mat[i][1]);
                ans += Math.abs(min - grid[i][j]);
            }
        }
        return ans;
    }
}