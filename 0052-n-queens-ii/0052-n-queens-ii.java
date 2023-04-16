class Solution {
    public int totalNQueens(int n) {
        char[][] mat = new char[n][n];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                mat[i][j] = '.';
            }
        }
        List<List<String>> al = new ArrayList<>();
        helper(0,al,n,mat);
        return al.size();
    }
    
    public void helper(int currRow,List<List<String>> al,int n,char[][] mat){
        if(currRow == n){
            List<String> curr = populate(mat,n);
            al.add(curr);
            return;
        }
        
        for(int currCol = 0;currCol<n;currCol++){
            if(mat[currRow][currCol] == '.'){
                if(isValid(currRow,currCol,mat)){
                    mat[currRow][currCol] = 'Q';
                    helper(currRow+1,al,n,mat);
                    mat[currRow][currCol] = '.';
                }
            }
        }
    }
    
    public List<String> populate(char[][] mat,int n){
        List<String> al = new ArrayList<>();
        for(int i = 0;i<n;i++){
            String temp = "";
            for(int j = 0;j<n;j++){
                temp += mat[i][j];
            }
            al.add(temp);
        }
        return al;
    }
    
    public boolean isValid(int currRow,int currCol,char[][] mat){
        return isRowValid(currRow,mat) && isColValid(currCol,mat) && isDiagValid(currRow,currCol,mat);
    }
    
    public boolean isRowValid(int currRow,char[][] mat){
        
        for(int j = 0;j<mat.length;j++){
            if(mat[currRow][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
    public boolean isColValid(int currCol,char[][] mat){
        
        for(int i = 0;i<mat.length;i++){
            if(mat[i][currCol] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
    public boolean isDiagValid(int currRow,int currCol,char[][] mat){
        int i = currRow;
        int j = currCol;
        
        while(i>=0 && j>=0){
            if(mat[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        
        i = currRow;
        j = currCol;
        
        while(i<mat.length && j<mat.length){
            if(mat[i][j] == 'Q'){
                return false;
            }
            i++;
            j++;
        }
        
        i = currRow;
        j = currCol;
        
        while(i<mat.length && j>=0){
            if(mat[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        }
        
        i = currRow;
        j = currCol;
        
        while(i>=0 && j<mat.length){
            if(mat[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}