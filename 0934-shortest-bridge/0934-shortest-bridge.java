class Pair{
    int x;
    int y;
    int level;
    
    Pair(int x,int y,int level){
        this.x = x;
        this.y = y;
        this.level = level;
    }
}

class Solution{
    public int shortestBridge(int[][] grid){
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        boolean found = false;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(i,j,qu,grid,vis);
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        
        boolean[][] vis2 = new boolean[grid.length][grid[0].length];
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(vis2[rem.x][rem.y] == true){
                continue;
            }
            
            vis2[rem.x][rem.y] = true;
            if(grid[rem.x][rem.y] == 1){
                return rem.level - 1;
            }
            
            addNbr(rem.x-1,rem.y,rem.level,qu,vis2,grid);
            addNbr(rem.x,rem.y+1,rem.level,qu,vis2,grid);
            addNbr(rem.x+1,rem.y,rem.level,qu,vis2,grid);
            addNbr(rem.x,rem.y-1,rem.level,qu,vis2,grid);
        }
        return -1;
    }
    
    public void addNbr(int cr,int cc,int level,ArrayDeque<Pair> qu,boolean[][] vis2,int[][] grid){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid.length){
            return;
        }
        else if(grid[cr][cc] == 2){
            return;
        }
        else if(vis2[cr][cc] == true){
            return;
        }
        
        qu.add(new Pair(cr,cc,level+1));
    }
    
    public void dfs(int cr,int cc,ArrayDeque<Pair> qu,int[][] grid,boolean[][] vis){
        if(cr<0 || cc<0 || cr>=grid.length || cc >= grid.length || grid[cr][cc] == 0 ||vis[cr][cc] == true){
            return;
        }
        
        vis[cr][cc] = true;
        qu.add(new Pair(cr,cc,0));
        
        dfs(cr-1,cc,qu,grid,vis);
        dfs(cr,cc+1,qu,grid,vis);
        dfs(cr+1,cc,qu,grid,vis);
        dfs(cr,cc-1,qu,grid,vis);
        grid[cr][cc] = 2;
        return;
    }
}