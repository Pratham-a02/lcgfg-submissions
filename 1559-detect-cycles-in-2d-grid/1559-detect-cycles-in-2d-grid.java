class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!vis[i][j]){
                    boolean flag = dfs(i,j,-1,-1,grid,vis,dirs);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int currRow,int currCol,int prow,int pcol,char[][] grid,boolean[][] vis,int[][] dirs){
        vis[currRow][currCol] = true;
        
        for(int[] dir:dirs){
            int r = currRow + dir[0];
            int c = currCol + dir[1];
            
            if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] != grid[currRow][currCol] || (r == prow && c == pcol)){
                continue;
            }
            
            if(vis[r][c] == true){
                return true;
            }
            
            boolean flag = dfs(r,c,currRow,currCol,grid,vis,dirs);
            if(flag){
                return true;
            }
        }
        return false;
    }
}