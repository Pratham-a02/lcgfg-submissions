class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        
        while(i<m && j>=0){//j>=0 so that we do not move out of matrix
            //i<m so that we do not go out of bound
            if(matrix[i][j] == target){
                return true;
            }
            
            if(matrix[i][j] > target){
                j--;
            }
            else if(matrix[i][j] < target){
                i++;
            }
        }
        
        return false;
    }
}