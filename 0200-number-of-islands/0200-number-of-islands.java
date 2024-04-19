class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        for(int currRow = 0;currRow<m;currRow++){
            for(int currCol = 0;currCol<n;currCol++){
                if(grid[currRow][currCol] == '1'){
                    count++;
                    helper(currRow,currCol,m,n,grid);
                }
            }
        }
        return count;
    }
    
    public void helper(int currRow,int currCol,int m,int n,char[][] grid){
        if(currRow<0 || currRow>=m || currCol<0 || currCol>=n || grid[currRow][currCol] == '0'){
            return;
        }
        grid[currRow][currCol] = '0';
        
        helper(currRow-1,currCol,m,n,grid);
        helper(currRow,currCol+1,m,n,grid);
        helper(currRow+1,currCol,m,n,grid);
        helper(currRow,currCol-1,m,n,grid);
        
        return;
    }
}