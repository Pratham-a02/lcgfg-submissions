class Solution{
    public int numberOfArithmeticSlices(int[] nums){
        if(nums.length<3){
            return 0;
        }
        
        int[] ans = new int[1];
        slices(nums.length-1,nums,ans);
        return ans[0];
    }
    
    public int slices(int n,int[] nums,int[] ans){
        if(n<2){
            return 0;
        }
        
        int count = 0;
        
        if(nums[n] - nums[n-1] == nums[n-1]-nums[n-2]){
            count = 1 + slices(n-1,nums,ans);
            ans[0] += count;
        }
        else{
            slices(n-1,nums,ans);
        }
        
        return count;
    }
}