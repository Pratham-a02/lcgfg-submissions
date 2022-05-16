class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] grid = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                grid[i][j] = '.';
            }
        }
        NQueen(grid,0,n,answer);
        return answer;
    }
    
    private void NQueen(char[][] grid,int currRow,int n,List<List<String>> answer){
        if(currRow == n){
            List<String> tempAns = populateAns(grid,n);
            answer.add(tempAns);
            return;
        }
        
        for(int currCol = 0;currCol<n;currCol++){
            if(isValid(grid,currRow,currCol,n)){
                grid[currRow][currCol] = 'Q';
                NQueen(grid,currRow+1,n,answer);
                grid[currRow][currCol] = '.';
            }
        }
        return;
    }
        
        private List<String> populateAns(char[][] grid, int n){
            List<String> ans = new ArrayList<>();
            for(int i = 0;i<n;i++){
                String tempAns = "";
                for(int j = 0;j<n;j++){
                    tempAns += grid[i][j];
                }
                ans.add(tempAns);
            }
            
            return ans;
        }
        
        
    private boolean isValid(char[][] grid,int currRow,int currCol,int n){
        return isRowValid(grid,currRow,n) && isColValid(grid,currCol,n) &&                              areDiagValid(grid,currRow,currCol,n);
    }
    private boolean isRowValid(char[][] grid,int currRow,int n){
        for(int j = 0;j<n;j++){
            if(grid[currRow][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private boolean isColValid(char[][] grid,int currCol,int n){
        for(int i = 0;i<n;i++){
            if(grid[i][currCol] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private boolean areDiagValid(char[][] grid,int currRow,int currCol,int n){
        
        int i = currRow;
        int j = currCol;
        
        while(i>=0 && j>=0){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i -= 1;
            j -= 1;
        }
        i = currRow;
        j = currCol;
        while(i>=0 && j<n){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i -= 1;
            j += 1;
        }
        
        i = currRow;
        j = currCol;
        while(i<n && j>=0){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i += 1;
            j -= 1;
        }
        
        i = currRow;
        j = currCol;
        while(i<n && j<n){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i += 1;
            j += 1;
        }
        return true;
    }
}