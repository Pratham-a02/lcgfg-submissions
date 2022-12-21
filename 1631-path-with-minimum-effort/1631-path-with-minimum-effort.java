class Pair implements Comparable<Pair>{
    int row;
    int col;
    int eff;
    
    Pair(int row,int col,int eff){
        this.row = row;
        this.col = col;
        this.eff = eff;
    }
    public int compareTo(Pair o){
        return this.eff - o.eff;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,0));
        int[][] dist = new int[heights.length][heights[0].length];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                dist[i][j] = (int)1e9;
            }
        }
        
        dist[0][0] = 0; 
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(pq.size()>0){
            Pair rem = pq.remove();
            int row = rem.row;
            int col = rem.col;
            int eff = rem.eff;
            if(row == m-1 && col == n-1){
                return eff;
            }
            
            for(int i = 0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                
                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n){
                     int neff = Math.max(eff,Math.abs(heights[row][col] - heights[nrow][ncol]));
                    if(neff < dist[nrow][ncol]){
                        dist[nrow][ncol] = neff;
                        pq.add(new Pair(nrow,ncol,neff));
                    }
                }
            }
        }
        return 0;
    }
}