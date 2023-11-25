class Solution{
    public int[] getSumAbsoluteDifferences(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        
        int[] ls = new int[n];
        int[] rs = new int[n];
        
        int ps = 0;
        
        for(int i = 0;i<n;i++){
            ps += nums[i];
            ls[i] = ps;
        }
        ps = 0;
        for(int i = n-1;i>=0;i--){
            ps += nums[i];
            rs[i] = ps;
        }
        ans[0] = rs[1] - (n-1) * nums[0];
        ans[n-1] = (n-1)*nums[n-1] - ls[n-2];
        for (int i = 1; i<n-1; i++){
            
            ans[i] = (rs[i+1] - ((n-i-1) * nums[i])) + ((i * nums[i]) - ls[i-1]);
        }
        return ans;
        
    }
}