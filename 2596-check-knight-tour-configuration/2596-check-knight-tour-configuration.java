class Solution {
    public boolean checkValidGrid(int[][] grid) {
        isPossible(0,0,grid[0][0],grid.length,grid);
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] != -1){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void isPossible(int i,int j,int curr,int n,int[][] grid){
        if(i<0 || j<0 || i>=n || j>=n || grid[i][j] != curr){
            return;
        }
        
        grid[i][j] = -1;
        
        isPossible(i-2,j+1,curr+1,n,grid);
        isPossible(i-1,j+2,curr+1,n,grid);
        isPossible(i+1,j+2,curr+1,n,grid);
        isPossible(i+2,j+1,curr+1,n,grid);
        isPossible(i+2,j-1,curr+1,n,grid);
        isPossible(i+1,j-2,curr+1,n,grid);
        isPossible(i-1,j-2,curr+1,n,grid);
        isPossible(i-2,j-1,curr+1,n,grid);
        
    }
}