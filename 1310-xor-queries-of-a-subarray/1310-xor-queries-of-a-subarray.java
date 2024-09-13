class Solution{
    public int[] xorQueries(int[] arr,int[][] queries){
        int n = arr.length;
        int[] nums = new int[n];
        
        nums[0] = arr[0];
        for (int idx = 1; idx < n; idx++) {
            nums[idx] = nums[idx - 1] ^ arr[idx];
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            if (u == 0) {
                ans[i] = nums[v]; 
            } else {
                ans[i] = nums[v] ^ nums[u - 1];
            }
        }
        
        return ans;
    }
}