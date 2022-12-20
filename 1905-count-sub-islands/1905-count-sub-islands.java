class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
       int m = grid1.length;
       int n = grid1[0].length;
        
       int count = 0;
       int[][] vis = new int[m][n];
       HashSet<Boolean> hs = new HashSet<>();
       for(int i = 0;i<m;i++){
           for(int j = 0;j<n;j++){
               if(grid2[i][j] == 1){
                   dfs(i,j,grid1,grid2,hs,vis);
                   
                   if(!hs.contains(false)){
                       count++;
                   }
                   hs.clear();
               }
           }
       }
        return count;
    }
    
    public void dfs(int currRow,int currCol,int[][] grid1,int[][] grid2,HashSet<Boolean> hs,int[][] vis){
        if(currRow<0 || currCol<0 || currRow>=grid1.length || currCol>=grid1[0].length || vis[currRow][currCol] == 1 || grid2[currRow][currCol] == 0){
            return;
        }
        
        if(grid2[currRow][currCol] == 1 && grid1[currRow][currCol] != 1){
            if(hs.size() == 0){
                hs.add(false);
            }
        }
        
        grid2[currRow][currCol] = 0;
        vis[currRow][currCol] = 1;
        
        dfs(currRow-1,currCol,grid1,grid2,hs,vis);
        dfs(currRow,currCol+1,grid1,grid2,hs,vis);
        dfs(currRow+1,currCol,grid1,grid2,hs,vis);
        dfs(currRow,currCol-1,grid1,grid2,hs,vis);
        
        return;
    }
}