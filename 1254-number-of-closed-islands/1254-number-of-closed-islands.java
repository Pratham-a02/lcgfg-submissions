class Solution{
    public int closedIsland(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i*j == 0 || i == m-1 || j == n-1){
                    if(grid[i][j] == 0){
                        dfs(i,j,m,n,grid);
                    }
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0){
                    count++;
                    dfs(i,j,m,n,grid);
                }
            }
        }
        return count;
    }
    
    public void dfs(int currRow,int currCol,int m,int n,int[][] grid){
        if(currRow>=m || currRow<0 || currCol>=n || currCol<0 || grid[currRow][currCol] == 1){
            return;
        }
        
        grid[currRow][currCol] = 1;
        
        dfs(currRow-1,currCol,m,n,grid);
        dfs(currRow,currCol+1,m,n,grid);
        dfs(currRow+1,currCol,m,n,grid);
        dfs(currRow,currCol-1,m,n,grid);
        
        return;
    }
}