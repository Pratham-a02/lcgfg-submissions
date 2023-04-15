class Solution{
    public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        
        while(lo<hi){
            int mid = lo - (lo-hi)/2;
            
            int count = 0;
            int j = matrix[0].length-1;
            for(int i = 0;i<n;i++){
                while(j>=0 && mid<matrix[i][j]){
                    j--;
                }
                count += (j+1);
            }
            
            if(count < k){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        
        return lo;
    }
}