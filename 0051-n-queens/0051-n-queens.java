class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                grid[i][j] = '.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        solve(0,n,grid,ans);
        return ans;
    }
    
    public void solve(int currRow,int n,char[][] grid,List<List<String>> ans){
        if(currRow == n){
            List<String> curr = generate(grid,n);
            ans.add(curr);
            return;
        }
        
        for(int currCol = 0;currCol<n;currCol++){
            if(isValid(currRow,currCol,grid,n)){
                grid[currRow][currCol] = 'Q';
                solve(currRow+1,n,grid,ans);
                grid[currRow][currCol] = '.';
            }
        }
        return;
    }
    
    private List<String> generate(char[][] grid, int n){
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
    
    public boolean isValid(int currRow,int currCol,char[][] grid,int n){
        return isRowSame(currRow,grid,n) && isColSame(currCol,grid,n) && isDiagSame(currRow,currCol,grid,n);
    }
    
    public boolean isColSame(int col,char[][] grid,int n){
        for(int i = 0;i<n;i++){
            if(grid[i][col] == 'Q'){
                return false;
            }
        }
        
        return true;
    } 
    
    public boolean isRowSame(int row,char[][] grid,int n){
        for(int j = 0;j<n;j++){
            if(grid[row][j] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isDiagSame(int row,int col,char[][] grid,int n){
        int i = row;
        int j = col;
        
        while(i>=0 && j>=0){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        
        i = row;
        j = col;
        
        while(i>=0 && j<n){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        
        i = row;
        j = col;
        
        while(i<n && j>=0){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        }
        
        i = row;
        j = col;
        
        while(i<n && j<n){
            if(grid[i][j] == 'Q'){
                return false;
            }
            i++;
            j++;
        }
        
        return true;
    }
}