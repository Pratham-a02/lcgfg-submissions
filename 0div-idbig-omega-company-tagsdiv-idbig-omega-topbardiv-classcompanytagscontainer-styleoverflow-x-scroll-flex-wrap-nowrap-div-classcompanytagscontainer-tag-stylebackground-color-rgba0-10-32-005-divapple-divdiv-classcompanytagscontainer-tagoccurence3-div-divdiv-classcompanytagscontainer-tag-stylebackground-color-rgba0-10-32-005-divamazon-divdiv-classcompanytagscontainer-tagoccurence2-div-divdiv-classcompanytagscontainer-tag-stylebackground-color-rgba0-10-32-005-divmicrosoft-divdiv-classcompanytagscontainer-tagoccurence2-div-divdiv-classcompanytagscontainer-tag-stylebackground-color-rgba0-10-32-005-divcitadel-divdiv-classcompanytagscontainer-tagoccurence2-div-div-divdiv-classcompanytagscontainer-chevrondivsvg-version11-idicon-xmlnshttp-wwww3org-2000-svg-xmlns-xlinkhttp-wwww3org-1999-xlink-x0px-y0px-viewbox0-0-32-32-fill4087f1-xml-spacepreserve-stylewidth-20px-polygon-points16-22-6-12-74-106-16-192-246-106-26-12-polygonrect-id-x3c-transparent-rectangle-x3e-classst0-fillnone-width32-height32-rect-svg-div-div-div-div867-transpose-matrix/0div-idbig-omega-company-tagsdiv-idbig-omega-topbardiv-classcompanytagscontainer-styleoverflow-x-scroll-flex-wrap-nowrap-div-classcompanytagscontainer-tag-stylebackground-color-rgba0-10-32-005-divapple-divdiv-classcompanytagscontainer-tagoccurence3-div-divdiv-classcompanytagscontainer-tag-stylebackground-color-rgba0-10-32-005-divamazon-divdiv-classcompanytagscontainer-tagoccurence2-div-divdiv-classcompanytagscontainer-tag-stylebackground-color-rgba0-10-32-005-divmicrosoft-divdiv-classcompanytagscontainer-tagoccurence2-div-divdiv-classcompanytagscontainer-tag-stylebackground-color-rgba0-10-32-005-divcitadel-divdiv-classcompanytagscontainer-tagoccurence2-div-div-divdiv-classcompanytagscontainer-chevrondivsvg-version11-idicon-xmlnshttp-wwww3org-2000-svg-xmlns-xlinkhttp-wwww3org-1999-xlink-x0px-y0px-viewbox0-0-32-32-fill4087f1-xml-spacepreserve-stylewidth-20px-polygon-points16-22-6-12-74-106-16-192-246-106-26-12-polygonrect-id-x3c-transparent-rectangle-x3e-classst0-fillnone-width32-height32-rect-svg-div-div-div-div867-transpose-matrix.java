class Solution {
    public int[][] transpose(int[][] matrix) {
        // int n = matrix.length;
        
        // for (int i=0; i<n; i++) {
        //     for (int j=i+1; j<n; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }
        
       int[][] ans = new int[matrix[0].length][matrix.length];
       for(int i = 0;i<ans.length;i++){
           for(int j = 0;j<ans[0].length;j++){
               ans[i][j] = matrix[j][i];
           }
       }
        
        return ans;
    }
}
