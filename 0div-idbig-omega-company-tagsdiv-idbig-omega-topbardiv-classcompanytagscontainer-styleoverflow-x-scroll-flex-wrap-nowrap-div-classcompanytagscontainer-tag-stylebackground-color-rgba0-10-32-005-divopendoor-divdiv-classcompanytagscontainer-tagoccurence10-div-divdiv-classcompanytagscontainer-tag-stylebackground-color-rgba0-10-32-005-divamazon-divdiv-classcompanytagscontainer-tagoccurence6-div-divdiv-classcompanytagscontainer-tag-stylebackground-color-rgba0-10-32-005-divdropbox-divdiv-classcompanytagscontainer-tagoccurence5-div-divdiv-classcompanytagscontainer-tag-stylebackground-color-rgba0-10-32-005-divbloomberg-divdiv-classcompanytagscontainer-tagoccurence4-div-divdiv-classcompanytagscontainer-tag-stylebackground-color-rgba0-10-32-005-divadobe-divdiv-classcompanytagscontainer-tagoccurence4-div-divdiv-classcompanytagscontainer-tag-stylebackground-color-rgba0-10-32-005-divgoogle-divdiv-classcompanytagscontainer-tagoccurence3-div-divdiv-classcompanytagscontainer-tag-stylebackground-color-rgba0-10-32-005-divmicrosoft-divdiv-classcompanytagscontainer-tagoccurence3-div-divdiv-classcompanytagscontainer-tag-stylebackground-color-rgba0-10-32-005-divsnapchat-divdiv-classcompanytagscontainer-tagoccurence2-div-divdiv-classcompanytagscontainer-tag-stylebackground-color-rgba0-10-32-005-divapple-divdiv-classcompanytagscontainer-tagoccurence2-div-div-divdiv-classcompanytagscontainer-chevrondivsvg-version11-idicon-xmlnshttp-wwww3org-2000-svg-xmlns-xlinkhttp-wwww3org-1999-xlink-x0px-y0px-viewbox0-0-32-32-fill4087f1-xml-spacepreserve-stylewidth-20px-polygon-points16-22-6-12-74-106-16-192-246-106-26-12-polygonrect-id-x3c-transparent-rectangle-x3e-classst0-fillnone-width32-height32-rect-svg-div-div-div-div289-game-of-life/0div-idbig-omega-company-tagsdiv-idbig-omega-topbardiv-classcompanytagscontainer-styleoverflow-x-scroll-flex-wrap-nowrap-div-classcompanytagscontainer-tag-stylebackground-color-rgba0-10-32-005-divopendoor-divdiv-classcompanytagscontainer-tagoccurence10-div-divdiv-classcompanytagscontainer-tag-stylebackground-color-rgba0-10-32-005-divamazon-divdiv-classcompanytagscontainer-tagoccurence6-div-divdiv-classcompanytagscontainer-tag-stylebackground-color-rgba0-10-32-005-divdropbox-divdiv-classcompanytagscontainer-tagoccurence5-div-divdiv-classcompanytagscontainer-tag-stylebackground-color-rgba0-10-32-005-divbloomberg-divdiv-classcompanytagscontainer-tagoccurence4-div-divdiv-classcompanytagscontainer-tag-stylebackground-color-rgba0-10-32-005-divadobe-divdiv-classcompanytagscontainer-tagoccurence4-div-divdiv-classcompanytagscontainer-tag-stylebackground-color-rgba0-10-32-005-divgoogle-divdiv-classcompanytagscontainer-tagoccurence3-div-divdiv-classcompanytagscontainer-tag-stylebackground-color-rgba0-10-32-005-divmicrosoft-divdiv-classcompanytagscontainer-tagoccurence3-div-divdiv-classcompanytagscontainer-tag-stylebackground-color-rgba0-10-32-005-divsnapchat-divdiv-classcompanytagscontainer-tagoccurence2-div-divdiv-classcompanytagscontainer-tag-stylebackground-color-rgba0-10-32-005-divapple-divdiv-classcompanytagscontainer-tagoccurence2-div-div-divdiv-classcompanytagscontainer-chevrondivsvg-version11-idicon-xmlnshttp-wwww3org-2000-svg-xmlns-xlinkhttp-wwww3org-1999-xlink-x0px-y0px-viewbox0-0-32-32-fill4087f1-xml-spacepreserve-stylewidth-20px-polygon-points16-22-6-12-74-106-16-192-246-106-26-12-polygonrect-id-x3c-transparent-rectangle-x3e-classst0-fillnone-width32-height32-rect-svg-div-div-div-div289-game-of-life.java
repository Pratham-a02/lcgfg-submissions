class Solution{
    int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public void gameOfLife(int[][] board){
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int count = 0;
                for(int[]dir:dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(isValid(x,y,m,n)){
                        if(board[x][y] == 1 || board[x][y] == -2){
                            count++;
                        }
                    }
                }
                if(board[i][j] == 0){
                    if(count == 3){
                        board[i][j] = 3;
                    }
                }
                else{
                    if(count < 2 || count > 3){
                        board[i][j] = -2;
                    }
                }
            }
        }
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                else if(board[i][j] == -2){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    public boolean isValid(int i,int j,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }
        return true;
    }
}