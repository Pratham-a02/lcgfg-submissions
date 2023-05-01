class Solution{
    public int[] productExceptSelf(int[] nums){
        int[] pfl = new int[nums.length];
        
        int n = nums.length;
        pfl[0] = 1;
        
        
        for(int i = 1;i<n;i++){
            pfl[i] = pfl[i-1]*nums[i-1];
        }
        
        int right = 1;
        for(int i = n-1;i>=1;i--){
            right = right*nums[i];
            pfl[i-1] = pfl[i-1]*right;
        }
        
        return pfl;
    }
}