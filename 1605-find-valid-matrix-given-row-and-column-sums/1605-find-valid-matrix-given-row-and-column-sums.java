class Solution{
    public int[][] restoreMatrix(int[] rowSum,int[] colSum){
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        
        int i = 0;
        int j = 0;
        
        while(i<m && j<n){
            int val1 = rowSum[i];
            int val2 = colSum[j];
            
            if(val1<val2){
                ans[i][j] = val1;
                rowSum[i] = 0;
                colSum[j] -= val1;
                i++;
            }
            else{
                ans[i][j] = val2;
                colSum[j] = 0;
                rowSum[i] -= val2;
                j++;
            }
        }
        
        return ans;
    }
}