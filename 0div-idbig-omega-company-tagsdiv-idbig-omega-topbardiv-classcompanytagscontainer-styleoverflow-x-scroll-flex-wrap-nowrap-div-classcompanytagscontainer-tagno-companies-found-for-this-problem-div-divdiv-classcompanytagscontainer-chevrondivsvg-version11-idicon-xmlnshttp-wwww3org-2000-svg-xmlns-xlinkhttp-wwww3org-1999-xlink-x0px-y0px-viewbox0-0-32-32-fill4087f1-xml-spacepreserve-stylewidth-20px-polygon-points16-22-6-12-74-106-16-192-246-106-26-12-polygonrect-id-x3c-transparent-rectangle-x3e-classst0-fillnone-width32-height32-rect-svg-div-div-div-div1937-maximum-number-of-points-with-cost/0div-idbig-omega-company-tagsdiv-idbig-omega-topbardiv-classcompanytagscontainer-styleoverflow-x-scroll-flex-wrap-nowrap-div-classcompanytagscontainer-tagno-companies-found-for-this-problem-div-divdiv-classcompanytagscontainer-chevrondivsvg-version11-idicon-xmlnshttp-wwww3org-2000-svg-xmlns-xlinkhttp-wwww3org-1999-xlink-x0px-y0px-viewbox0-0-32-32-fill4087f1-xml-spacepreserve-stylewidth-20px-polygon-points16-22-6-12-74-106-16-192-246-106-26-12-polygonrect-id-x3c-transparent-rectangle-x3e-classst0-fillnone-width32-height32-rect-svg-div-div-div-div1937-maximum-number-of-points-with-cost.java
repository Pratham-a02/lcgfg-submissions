class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] prev = new long[n];
        long ans = 0;
        for(int i = 0;i<n;i++){
            prev[i] = points[0][i];
        }
        
        for(int i = 1;i<m;i++){
            long[] left = new long[n];
            long[] right = new long[n];
            long[] curr = new long[n];
            
            left[0] = prev[0];
            
            for(int j = 1;j<n;j++){
                left[j] = Math.max(prev[j],left[j-1]-1);
            }
            
            right[n-1] = prev[n-1];
            
            for(int j = n-2;j>=0;j--){
                right[j] = Math.max(prev[j],right[j+1]-1);
            }
            
            for(int j = 0;j<n;j++){
                curr[j] = points[i][j] + Math.max(left[j],right[j]);
            }
            
            prev = curr;
        }
        
        for(long val:prev){
            ans = Math.max(ans,val);
        }
        return ans;
    }
}