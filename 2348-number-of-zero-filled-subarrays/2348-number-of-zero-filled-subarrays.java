class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int left = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                left = i;
                break;
            }
        }
        
        int right = left;
        while(right<nums.length){
            while(right<nums.length && nums[right] == 0){
                count += (right - left + 1);
                right++;
            }
            if(right<nums.length && left<nums.length && nums[right] != 0){
                while(left != right){
                    left++;
                }
                left++;
                right = left;
            }
        }
        return count;
    }
}