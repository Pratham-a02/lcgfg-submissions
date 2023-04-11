class Solution {
    public void solveSudoku(char[][] board) {
        helper(0,0,board);
    }
    
    public boolean helper(int currRow,int currCol,char[][] board){
        if(currRow == 9){
            return true;
        }
        
        int nextRow = 0;
        int nextCol = 0;
        
        if(currCol == 8){
            nextRow = currRow+1;
            nextCol = 0;
        }
        else{
            nextRow = currRow;
            nextCol = currCol+1;
        }
        
        if(board[currRow][currCol] != '.'){
            return helper(nextRow,nextCol,board);
        }
        else{
            for(int i = 1;i<10;i++){
                if(isValid(board,currRow,currCol,i)){
                    board[currRow][currCol] = (char)(i+'0');

                    if(helper(nextRow,nextCol,board)){
                        return true;
                    }
                    else{
                        board[currRow][currCol] = '.';
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col, int number) {
       //column
       for(int i=0; i<board.length; i++) {
           if(board[i][col] == (char)(number+'0')) {
               return false;
           }
       }
      
       //row
       for(int j=0; j<board.length; j++) {
           if(board[row][j] == (char)(number+'0')) {
               return false;
           }
       }
      
       //grid
       int sr = 3 * (row/3);
       int sc = 3 * (col/3);
      
       for(int i=sr; i<sr+3; i++) {
           for(int j=sc; j<sc+3; j++) {
               if(board[i][j] == (char)(number+'0')) {
                   return false;
               }
           }
       }

        return true;
    }
}