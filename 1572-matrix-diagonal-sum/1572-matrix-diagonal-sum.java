class Solution{
    public int diagonalSum(int[][] mat){
        int n = mat.length;
        int ans = 0;
        
        int i = 0;
        int j = 0;
        while(i<n && j<n){
            ans += mat[i][j];
            i++;
            j++;
        }
        
        i = 0;
        j = n-1;
        while(i<n && j>=0){
            ans += mat[i][j];
            i++;
            j--;
        }
        
        return (n%2 == 0)?ans:ans-mat[n/2][n/2];
    }
}