class Solution {
    public int maxAreaOfIsland(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); 
        // int max = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    int[] count = new int[1];
                    // count[0]+=1;
                    dfs(i,j,count,grid);
                    // max = Math.max(max,count[0]);
                    maxPQ.add(count[0]);
                }
            }
        }
        if(maxPQ.size() == 0){
            return 0;
        }
        return maxPQ.peek();
    }
    
    public void dfs(int currRow,int currCol,int[] count,int[][] grid){
        if(currRow < 0 || currCol < 0 || currRow>=grid.length || currCol>=grid[0].length || grid[currRow][currCol] == 0){
            return;
        }
        
        grid[currRow][currCol] = 0;
        count[0]++;
        
        
        
        dfs(currRow-1,currCol,count,grid);
        dfs(currRow,currCol+1,count,grid);
        dfs(currRow+1,currCol,count,grid);
        dfs(currRow,currCol-1,count,grid);
        
        return;
    }
}