class Solution{
    int count = 0;
    public int islandPerimeter(int[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean found = false;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    dfs(i,j,grid,m,n);
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        return count;
    }
    
    public void dfs(int cr,int cc,int[][] grid,int m,int n){
        if(cr<0 || cc<0 || cr>= m || cc>=n || grid[cr][cc] == 0){
            count++;
            return;
        }
        
        if(grid[cr][cc] == -1){
            return;
        }
        
        grid[cr][cc] = -1;
        dfs(cr-1,cc,grid,m,n);
        dfs(cr,cc+1,grid,m,n);
        dfs(cr+1,cc,grid,m,n);
        dfs(cr,cc-1,grid,m,n);
        
        return;
    }
}