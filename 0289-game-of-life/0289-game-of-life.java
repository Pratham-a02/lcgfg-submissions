class Solution {
    public void gameOfLife(int[][] board){
        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int count = 0;
                for(int[] d:dir){
                    int x = i+d[0];
                    int y = j+d[1];
                    
                    if(isValid(x,y,board)){
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
                else if(board[i][j] == 1){
                    if(count<2 || count>3){
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
                else{
                    
                }
            }
        }
    }
    
    boolean isValid(int x,int y,int[][] board){
        if(x<0 || y<0 || x>=board.length || y >= board[0].length){
            return false;
        }
        return true;
    }
}