class Solution{
    public boolean isValidSudoku(char[][] board){
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] != '.'){
                    if(isValid(i,j,board,board[i][j]-'0') == false){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isValid(int row,int col,char[][] board,int number){
        for(int j = 0;j<board.length;j++){
            if(j != col){
                if(board[row][j]-'0' == number){
                    return false;
                }
            }
        }
        
        for(int i = 0;i<board.length;i++){
            if(i != row){
                if(board[i][col]-'0' == number){
                    return false;
                }
            }
        }
        
        int sr = 3 * (row/3);
        int sc = 3 * (col/3);
        
        for(int i = sr;i<sr+3;i++){
            for(int j = sc;j<sc+3;j++){
                if(i != row && j != col){
                    if(board[i][j] - '0' == number){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}