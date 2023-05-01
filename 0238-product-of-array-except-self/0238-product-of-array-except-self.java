class Solution{
    public int[] productExceptSelf(int[] nums){
        int[] pfl = new int[nums.length];
        int[] pfr = new int[nums.length];
        
        int n = nums.length;
        pfl[0] = 1;
        pfr[n-1] = 1;
        
        for(int i = 1;i<n;i++){
            pfl[i] = pfl[i-1]*nums[i-1];
        }
        
        for(int i = n-2;i>=0;i--){
            pfr[i] = nums[i+1]*pfr[i+1];
        }
        
        int[] ans = new int[n];
        
        for(int i = 0;i<n;i++){
            ans[i] = pfl[i]*pfr[i];
        }
        return ans;
    }
}