class Solution{
    public int[][] colorBorder(int[][] grid,int row,int col,int color){
        int orgc = grid[row][col];
        dfs(row,col,orgc,grid);
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == -orgc){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    
    public void dfs(int row,int col,int orgc,int[][] grid){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] != orgc){
            return;
        }
        grid[row][col] = -orgc;
        
        dfs(row-1,col,orgc,grid);
        dfs(row,col+1,orgc,grid);
        dfs(row+1,col,orgc,grid);
        dfs(row,col-1,orgc,grid);
        
        if(row > 0 && col > 0 && row<grid.length-1 && col < grid[0].length-1 && 
            Math.abs(grid[row-1][col]) == orgc &&
            Math.abs(grid[row][col+1]) == orgc &&
            Math.abs(grid[row+1][col]) == orgc &&
            Math.abs(grid[row][col-1]) == orgc){
            grid[row][col] = orgc;
        }
        
        return;
    }
}