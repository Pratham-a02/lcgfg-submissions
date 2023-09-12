class Solution{
    int count;
    public int islandPerimeter(int[][] grid){
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean found = false;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    found = true;
                    dfs(i,j,m,n,grid);
                    if(found){
                        break;
                    }
                }
            }
            if(found){
                break;
            }
        }
        return count;
    }
    
    public void dfs(int cr,int cc,int m,int n,int[][] grid){
        if(cr<0 || cc<0 || cr>=m || cc>=n || grid[cr][cc] == 0){
            count++;
            return;
        }
        
        if(grid[cr][cc] == -1){
            return;
        }
        grid[cr][cc] = -1;
        
        dfs(cr-1,cc,m,n,grid);
        dfs(cr,cc+1,m,n,grid);
        dfs(cr+1,cc,m,n,grid);
        dfs(cr,cc-1,m,n,grid);
        
        return;
    }
}