class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] vis = new boolean[n][n];
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        qu.add(1);
        int steps = 0;
        int dest = n*n;
        while(qu.size()>0){
            int size = qu.size();
            
            for(int i = 0;i<size;i++){
                int x = qu.remove();
                if(x == dest){
                    return steps;
                }
                
                for(int k = 1;k<=6;k++){
                    if(k+x>dest){
                        break;
                    }
                    int[] pos = findCoordinate(k+x,n);
                    
                    int r = pos[0];
                    int c = pos[1];
                    if(vis[r][c] == true){
                        continue;
                    }
                    vis[r][c] = true;
                    if(board[r][c] == -1){
                        qu.add(k+x);
                    }
                    else{
                        qu.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    public int[] findCoordinate(int curr,int n){
        int r = n - (curr-1)/n -1;
        int c = (curr-1)%n;
        
        if(r%2 == n%2){
            return new int[]{r,n-1-c};
        }
        else{
            return new int[]{r,c};
        }
    }
}