class Solution {
    public int partitionArray(int[] nums, int k) {
        if(nums.length == 1){
            return 1;
        }
        Arrays.sort(nums);
        
        int left = 0;
        int count = 0;
        for(int right = 0;right<nums.length;right++){
            if(left == right && right == nums.length-1){
                count++;
            }
            if(nums[right] - nums[left]<=k){
                continue;
            }
            
            if(nums[right] - nums[left]>k){
                count++;
                left = right;
            }
        }
        return count+1;
    }
}