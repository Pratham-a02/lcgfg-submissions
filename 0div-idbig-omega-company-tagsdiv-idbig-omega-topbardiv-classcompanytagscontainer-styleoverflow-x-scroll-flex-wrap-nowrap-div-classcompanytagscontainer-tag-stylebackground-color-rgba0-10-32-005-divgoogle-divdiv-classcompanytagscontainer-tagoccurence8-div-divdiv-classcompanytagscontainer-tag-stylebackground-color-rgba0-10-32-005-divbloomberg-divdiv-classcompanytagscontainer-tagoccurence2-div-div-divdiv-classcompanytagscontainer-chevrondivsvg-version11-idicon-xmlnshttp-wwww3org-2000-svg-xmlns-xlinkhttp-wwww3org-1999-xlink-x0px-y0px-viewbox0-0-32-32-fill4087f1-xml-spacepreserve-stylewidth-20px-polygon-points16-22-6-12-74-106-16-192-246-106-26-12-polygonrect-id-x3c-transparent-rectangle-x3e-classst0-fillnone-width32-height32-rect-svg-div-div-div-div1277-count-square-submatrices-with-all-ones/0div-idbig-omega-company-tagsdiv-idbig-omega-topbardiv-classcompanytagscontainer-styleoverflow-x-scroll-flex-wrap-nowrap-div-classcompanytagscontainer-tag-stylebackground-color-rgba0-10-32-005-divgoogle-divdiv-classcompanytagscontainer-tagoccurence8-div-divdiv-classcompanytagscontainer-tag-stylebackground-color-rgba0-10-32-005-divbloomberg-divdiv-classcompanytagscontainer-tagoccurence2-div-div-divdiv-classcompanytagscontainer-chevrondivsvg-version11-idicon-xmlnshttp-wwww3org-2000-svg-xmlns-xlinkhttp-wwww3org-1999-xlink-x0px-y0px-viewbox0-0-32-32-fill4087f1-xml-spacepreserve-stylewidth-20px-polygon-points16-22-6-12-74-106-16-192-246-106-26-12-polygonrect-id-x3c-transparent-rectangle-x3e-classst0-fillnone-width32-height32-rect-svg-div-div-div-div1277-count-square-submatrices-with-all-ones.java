class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize dp array with -1 for memoization
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        int totalSquares = 0;  // Total number of squares
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int side = solve(i, j, dp, matrix);
                    totalSquares += side;
                }
            }
        }
        
        return totalSquares;
    }
    
    private int solve(int cr, int cc, int[][] dp, int[][] mat) {
        if (cr >= mat.length || cc >= mat[0].length || mat[cr][cc] == 0) {
            return 0;
        }
        
        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }
        
        int right = 1 + solve(cr, cc + 1, dp, mat);
        int down = 1 + solve(cr + 1, cc, dp, mat);
        int diag = 1 + solve(cr + 1, cc + 1, dp, mat);
        
        dp[cr][cc] = Math.min(right, Math.min(down, diag));
        return dp[cr][cc];
    }
}
