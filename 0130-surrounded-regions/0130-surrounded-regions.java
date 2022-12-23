class Solution {
    public void solve(char[][] board){
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] vis = new boolean[m][n];
        for(int j = 0;j<n;j++){
            if(board[0][j] == 'O'){
                if(vis[0][j]){
                    continue;
                }
                markTrue(0,j,vis,board);
            }
        }
        
        for(int j = 0;j<m;j++){
            if(board[j][0] == 'O'){
                if(vis[j][0]){
                    continue;
                }
                markTrue(j,0,vis,board);
            }
        }
        
        for(int j = 0;j<n;j++){
            if(board[m-1][j] == 'O'){
                if(vis[m-1][j]){
                    continue;
                }
                markTrue(m-1,j,vis,board);
            }
        }
        
        for(int j = 0;j<m;j++){
            if(board[j][n-1] == 'O'){
                if(vis[j][n-1]){
                    continue;
                }
                markTrue(j,n-1,vis,board);
            }
        }
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void markTrue(int r,int c,boolean[][] vis,char[][] board){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c] != 'O' || vis[r][c] == true){
            return;
        }
        
        vis[r][c] = true;
        
        markTrue(r-1,c,vis,board);
        markTrue(r,c+1,vis,board);
        markTrue(r+1,c,vis,board);
        markTrue(r,c-1,vis,board);
        
        return;
    }
}