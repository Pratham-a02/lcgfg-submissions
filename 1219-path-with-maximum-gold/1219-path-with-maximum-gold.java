class Solution{
    public int getMaximumGold(int[][] grid){
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] != 0){
                    max = Math.max(max,solve(i,j,grid,vis));
                }
            }
        }
        return max;
    }
    
    public int solve(int cr,int cc,int[][] grid,boolean[][] vis){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length || grid[cr][cc] == 0 || vis[cr][cc] == true){
            return 0;
        }
        
        vis[cr][cc] = true;
        int up = grid[cr][cc] + solve(cr-1,cc,grid,vis);
        int left = grid[cr][cc] + solve(cr,cc-1,grid,vis);
        int right = grid[cr][cc] + solve(cr,cc+1,grid,vis);
        int down = grid[cr][cc] + solve(cr+1,cc,grid,vis);
        vis[cr][cc] = false;
        
        return Math.max(up,Math.max(left,Math.max(right,down)));
    }
}