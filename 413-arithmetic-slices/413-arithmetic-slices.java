class Solution {
    int ans = 0;
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length == 1 || nums.length == 2) return 0;
        int n = nums.length;
        slices(n-1,nums);
        return ans;
    }
   
    public int slices(int i,int[] nums){
        if(i<2) return 0;
       
        int count = 0;
        
        if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
            count = 1 + (slices(i-1,nums));
            ans = ans + count;
        }
        else{
            slices(i-1,nums);
        }
        
        return count;
        
    }
    
}