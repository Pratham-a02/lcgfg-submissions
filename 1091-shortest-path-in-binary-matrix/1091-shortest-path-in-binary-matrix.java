class Pair implements Comparable<Pair>{
    int x;
    int y;
    int dist;
    
    Pair(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    
    public int compareTo(Pair o){
        return this.dist - o.dist;
    }
}
class Solution{
    public int shortestPathBinaryMatrix(int[][] grid){
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,1));
        boolean[][] vis = new boolean[n][n];
        while(pq.size()>0){
            Pair rem = pq.remove();
            
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            
            vis[rem.x][rem.y] = true;
            
            if(rem.x == n-1 && rem.y == n-1){
                return rem.dist;
            }
            
            addPair(rem.x-1,rem.y,rem.dist+1,pq,vis,grid);
            addPair(rem.x,rem.y+1,rem.dist+1,pq,vis,grid);
            addPair(rem.x+1,rem.y,rem.dist+1,pq,vis,grid);
            addPair(rem.x,rem.y-1,rem.dist+1,pq,vis,grid);
            addPair(rem.x-1,rem.y+1,rem.dist+1,pq,vis,grid);
            addPair(rem.x+1,rem.y+1,rem.dist+1,pq,vis,grid);
            addPair(rem.x+1,rem.y-1,rem.dist+1,pq,vis,grid);
            addPair(rem.x-1,rem.y-1,rem.dist+1,pq,vis,grid);
        }
        return -1;
    }
    
    public void addPair(int x,int y,int dist,PriorityQueue<Pair> pq,boolean[][] vis,int[][] grid){
        if(x<0 || y<0 || x>=grid.length || y>=grid.length || grid[x][y] == 1 || vis[x][y] == true){
            return;
        }
        
        pq.add(new Pair(x,y,dist));
    }
}