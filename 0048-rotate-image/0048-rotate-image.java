class Solution{
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int[] num:matrix){
            int i = 0;
            int j = num.length-1;
            
            while(i<=j){
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                i++;
                j--;
            }
        }
    }
}