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

class Solution{
    public int[][] updateMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        
        boolean[][] vis = new boolean[m][n];
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            mat[rem.x][rem.y] = rem.dist;
            vis[rem.x][rem.y] = true;
            
            if(rem.x - 1 >= 0){
                qu.add(new Pair(rem.x-1,rem.y,rem.dist+1));
            }
            if(rem.y+1<n){
                qu.add(new Pair(rem.x,rem.y+1,rem.dist+1));
            }
            if(rem.x + 1 <m){
                qu.add(new Pair(rem.x+1,rem.y,rem.dist+1));
            }
            if(rem.y-1>=0){
                qu.add(new Pair(rem.x,rem.y-1,rem.dist+1));
            }
            
        }
        return mat;
    }
}