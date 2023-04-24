class Solution{
    public int[] findBall(int[][] grid){
        int[] ans = new int[grid[0].length];
        for(int i = 0;i<grid[0].length;i++){
            ans[i] = dfs(0,i,grid,0);
        }
        return ans;
    }
    
    public int dfs(int currRow,int currCol,int[][] grid,int prev){
        if(currRow >= grid.length){
            return currCol;
        }
        
        if(currCol < 0 || currCol >= grid[0].length){
            return -1;
        }
        
        if(prev == 0){
            if(grid[currRow][currCol] == -1){
                return dfs(currRow,currCol-1,grid,grid[currRow][currCol]);
            }
            else if(grid[currRow][currCol] == 1){
                return dfs(currRow,currCol+1,grid,grid[currRow][currCol]);
            }
        }
        else{
            if(prev == grid[currRow][currCol]){
                return dfs(currRow+1,currCol,grid,0);
            }
        }
        return -1;
    }
}