class Solution{
    public int numEnclaves(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i*j == 0 || i == m-1 || j == n-1){
                    if(grid[i][j] == 1){
                        dfs(i,j,m,n,grid,vis);
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
    
    public void dfs(int cr,int cc,int m,int n,int[][] grid,boolean[][] vis){
        if(cr<0 || cc<0 || cr>=m || cc>=n || grid[cr][cc] == 0 || vis[cr][cc] == true){
            return;
        }
        
        vis[cr][cc] = true;
        grid[cr][cc] = 0;
        dfs(cr-1,cc,m,n,grid,vis);
        dfs(cr,cc+1,m,n,grid,vis);
        dfs(cr+1,cc,m,n,grid,vis);
        dfs(cr,cc-1,m,n,grid,vis);
        
        return;
    }
}