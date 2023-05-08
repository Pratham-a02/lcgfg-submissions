class Solution{
    public int diagonalSum(int[][] mat){
        int n = mat.length;
        int ans = 0;
        boolean[][] vis = new boolean[n][n];
        
        int i = 0;
        int j = 0;
        while(i<n && j<n){
            if(vis[i][j] == false){
                ans += mat[i][j];
                vis[i][j] = true;
            }
            i++;
            j++;
        }
        
        i = 0;
        j = n-1;
        while(i<n && j>=0){
            if(vis[i][j] == false){
                ans += mat[i][j];
                vis[i][j] = true;
            }
            i++;
            j--;
        }
        
        return ans;
    }
}