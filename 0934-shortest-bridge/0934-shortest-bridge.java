class Solution {
    
    class Pair{
        int i;
        int j;
        int level;
        
        Pair(int i,int j,int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        boolean found = false;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    helper(i,j,grid,qu,vis);
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        
        boolean[][] visited = new boolean[m][n];
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            if(grid[rem.i][rem.j] == 1){
                return rem.level-1;
            }
            
            if(rem.i-1>= 0 && grid[rem.i-1][rem.j] != 2 && visited[rem.i-1][rem.j] != true){
                qu.add(new Pair(rem.i-1,rem.j,rem.level+1));
            }
            if(rem.i+1<m && grid[rem.i+1][rem.j] != 2 && visited[rem.i+1][rem.j] != true){
                qu.add(new Pair(rem.i+1,rem.j,rem.level+1));
            }
            if(rem.j-1>= 0 && grid[rem.i][rem.j-1] != 2 && visited[rem.i][rem.j-1] != true){
                qu.add(new Pair(rem.i,rem.j-1,rem.level+1));
            }
            if(rem.j+1<n && grid[rem.i][rem.j+1] != 2 && visited[rem.i][rem.j+1] != true){
                qu.add(new Pair(rem.i,rem.j+1,rem.level+1));
            }
        }
        return -1;
    }
    
    public void helper(int currRow,int currCol,int[][] grid,ArrayDeque<Pair> qu,boolean[][] vis){
        if(currRow<0 || currCol<0 || currRow>=grid.length || currCol>=grid[0].length || grid[currRow][currCol] == 0 || vis[currRow][currCol] == true){
            return;
        }
        
        vis[currRow][currCol] = true;
        qu.add(new Pair(currRow,currCol,0));
        
        helper(currRow-1,currCol,grid,qu,vis);
        helper(currRow,currCol-1,grid,qu,vis);
        helper(currRow+1,currCol,grid,qu,vis);
        helper(currRow,currCol+1,grid,qu,vis);
        
        grid[currRow][currCol] = 2;
        return;
    }
}