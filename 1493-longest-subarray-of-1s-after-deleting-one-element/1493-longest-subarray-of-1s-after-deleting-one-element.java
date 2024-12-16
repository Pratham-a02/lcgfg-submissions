class Solution{
    public int longestSubarray(int[] nums){
        int count = 0;
        
        int max = Integer.MIN_VALUE;
        int left = 0;
        for(int right = 0;right<nums.length;right++){
            if(nums[right] == 0){
                count++;
            }
            
            if(count == 1){
                max = Math.max(max,right-left);
            }
            else if(count == 0){
                max = Math.max(max,right-left+1);
            }
            else if(count > 1){
                while(left<=right && count > 1){
                    if(nums[left] == 0){
                        count--;
                    }
                    left++;
                }
            }
        }
        if(max == nums.length){
            return nums.length-1;
        }
        return max;
    }
}