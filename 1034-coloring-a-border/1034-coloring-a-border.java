class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int orgc = grid[row][col];
        traverse(row,col,color,grid,orgc,m,n);
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == -orgc){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    
    public void traverse(int currRow,int currCol,int color,int[][] grid,int orgc,int m,int n){
        if(currRow<0 || currCol<0 || currRow>=m || currCol>=n || grid[currRow][currCol]!= orgc){
            return;
        }
        
        grid[currRow][currCol] = -orgc;
        traverse(currRow-1,currCol,color,grid,orgc,m,n);
        traverse(currRow,currCol-1,color,grid,orgc,m,n);
        traverse(currRow+1,currCol,color,grid,orgc,m,n);
        traverse(currRow,currCol+1,color,grid,orgc,m,n);
        
        if(currRow>0 && currRow<m-1 && currCol>0 && currCol<n-1 && 
           Math.abs(grid[currRow-1][currCol]) == orgc &&
           Math.abs(grid[currRow][currCol-1]) == orgc &&
           Math.abs(grid[currRow+1][currCol]) == orgc &&
           Math.abs(grid[currRow][currCol+1]) == orgc){
            grid[currRow][currCol] = orgc;
        }
        
        return;
    }
}