class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i<nums.length;i++){
            int prod = nums[i];
            
            for(int j = i+1;j<nums.length;j++){
                prod *= nums[j];
                max = Math.max(max,prod);            }
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}