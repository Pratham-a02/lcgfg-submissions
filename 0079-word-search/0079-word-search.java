class Solution{
    public boolean exist(char[][] board,String word){
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == word.charAt(0) && solve(i,j,m,n,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean solve(int x,int y,int m,int n,int idx,char[][] board,String word){
        if(idx == word.length()){
            return true;
        }
        if(x<0 || y<0 || x>=m || y>=n || word.charAt(idx) != board[x][y]){
            return false;
        }
        
        char temp = board[x][y];
        board[x][y] = '*';
        
        boolean flag = solve(x-1,y,m,n,idx+1,board,word) || solve(x,y+1,m,n,idx+1,board,word) || solve(x+1,y,m,n,idx+1,board,word) || solve(x,y-1,m,n,idx+1,board,word);
        
        board[x][y] = temp;
        return flag;
    }
}