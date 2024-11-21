class Solution{
    public int countUnguarded(int m,int n,int[][] guards,int[][] walls){
        int[][] mat = new int[m][n];
        for(int[] arr:mat){
            Arrays.fill(arr,-1);
        }
        for(int[] guard : guards){
            int i = guard[0];
            int j = guard[1];
            
            mat[i][j] = 0;
        }
        for(int[] wall : walls){
            int i = wall[0];
            int j = wall[1];
            
            mat[i][j] = 1;
        }
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    solve(i,j,mat);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == -1) ans++;
            }
        }
        return ans;
    }
    
    public void solve(int i,int j,int[][] mat){
        int x = i-1;
        int y = j;
        while(x>=0 && y>=0 && mat[x][y] != 1 && mat[x][y] != 0){
            mat[x][y] = 2;
            x--;
        }
        
        x = i;
        y = j-1;
        while(x>=0 && y>=0 && mat[x][y] != 1 && mat[x][y] != 0){
            mat[x][y] = 2;
            y--;
        }
        
        x = i+1;
        y = j;
        while(x<mat.length && mat[x][y] != 1 && mat[x][y] != 0){
            mat[x][y] = 2;
            x++;
        }
        x = i;
        y = j+1;
        while(y<mat[0].length && mat[x][y] != 1 && mat[x][y] != 0){
            mat[x][y] = 2;
            y++;
        }
    }
}