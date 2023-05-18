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
        
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        
        boolean[][] vis = new boolean[m][n];
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            
            vis[rem.x][rem.y] = true;
            mat[rem.x][rem.y] = rem.dist;
            
            if(rem.x-1>=0){
                qu.add(new Pair(rem.x-1,rem.y,rem.dist+1));
            }
            if(rem.y+1<n){
                qu.add(new Pair(rem.x,rem.y+1,rem.dist+1));
            }
            if(rem.x+1<m){
                qu.add(new Pair(rem.x+1,rem.y,rem.dist+1));
            }
            if(rem.y-1>=0){
                qu.add(new Pair(rem.x,rem.y-1,rem.dist+1));
            }
        }
        return mat;
    }
}