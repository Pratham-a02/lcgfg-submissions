class Solution {
    public boolean searchMatrix(int[][] matrix, int key){
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        
        while(i>=0 && j>=0 && i<m && j<n){
            if(matrix[i][j] == key){
                return true;
            }
            else if(matrix[i][j]>key){
                j--;
            }
            else if(matrix[i][j]<key){
                i++;
            }
        }
        
        return false;
    }
}