class Solution {
    class Pair{
        int x;
        int y;
        int dist;
        
        Pair(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int maxDistance(int[][] grid) {
        int max = 0;
        int[][] mat = updateMatrix(grid);
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                max = Math.max(max,mat[i][j]);
            }
        }
        if(max == 0){
            return -1;
        }
        return max;
    }
    
    public int[][] updateMatrix(int[][] grid){
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(vis[rem.x][rem.y]){
                continue;
            }
            vis[rem.x][rem.y] = true;
            grid[rem.x][rem.y] = rem.dist;
            
            if(rem.x-1>=0){// && grid[rem.x-1][rem.y]!=1){
                qu.add(new Pair(rem.x-1,rem.y,rem.dist+1));
            }
            if(rem.x+1<grid.length){// && grid[rem.x+1][rem.y]!=1){
                qu.add(new Pair(rem.x+1,rem.y,rem.dist+1));
            }
            if(rem.y-1>=0){// && grid[rem.x][rem.y-1]!=1){
                qu.add(new Pair(rem.x,rem.y-1,rem.dist+1));
            }
            if(rem.y+1<grid[0].length){// && grid[rem.x][rem.y+1]!=1){
                qu.add(new Pair(rem.x,rem.y+1,rem.dist+1));
            }
        }
        return grid;
    }
}