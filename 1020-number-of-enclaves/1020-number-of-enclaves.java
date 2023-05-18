class Solution{
    public int numEnclaves(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if((i*j == 0) || i == m-1 || j == n-1){
                    if(grid[i][j] == 1){
                        dfs(i,j,vis,grid);
                    }
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int cr,int cc,boolean[][] vis,int[][] grid){
        if(cr<0 || cr>=grid.length || cc<0 || cc>=grid[0].length || vis[cr][cc] == true || grid[cr][cc] == 0){
            return;
        }
        
        vis[cr][cc] = true;
        grid[cr][cc] = 0;
        
        dfs(cr-1,cc,vis,grid);
        dfs(cr,cc+1,vis,grid);
        dfs(cr+1,cc,vis,grid);
        dfs(cr,cc-1,vis,grid);
        
        return;
    }
}