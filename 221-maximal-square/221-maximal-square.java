class Solution {
    public int maximalSquare(char[][] matrix) {
        int area = 0;
        int side = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[310][310];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        
        for(int currRow = 0;currRow<m;currRow++){
            for(int currCol = 0;currCol<n;currCol++){
                if(matrix[currRow][currCol] == '1')
                    side = maxArea(currRow,currCol,m,n,matrix,dp);
                    area = Math.max(area,side*side);
            }
        }
        return area;
    }
    
    public int maxArea(int currRow,int currCol,int m,int n,char[][] matrix,int[][] dp){
        if(currRow<0 || currRow>=m || currCol<0 || currCol>=n || matrix[currRow][currCol] == '0')
            return 0;
        
        if(dp[currRow][currCol]!= -1)
            return dp[currRow][currCol];
        
        int right = 1 + maxArea(currRow,currCol+1,m,n,matrix,dp);
        int down = 1 + maxArea(currRow+1,currCol,m,n,matrix,dp);
        int dR = 1 + maxArea(currRow+1,currCol+1,m,n,matrix,dp);
        
        int first = Math.min(right,down);
        return dp[currRow][currCol] = Math.min(first,dR);

    }
}