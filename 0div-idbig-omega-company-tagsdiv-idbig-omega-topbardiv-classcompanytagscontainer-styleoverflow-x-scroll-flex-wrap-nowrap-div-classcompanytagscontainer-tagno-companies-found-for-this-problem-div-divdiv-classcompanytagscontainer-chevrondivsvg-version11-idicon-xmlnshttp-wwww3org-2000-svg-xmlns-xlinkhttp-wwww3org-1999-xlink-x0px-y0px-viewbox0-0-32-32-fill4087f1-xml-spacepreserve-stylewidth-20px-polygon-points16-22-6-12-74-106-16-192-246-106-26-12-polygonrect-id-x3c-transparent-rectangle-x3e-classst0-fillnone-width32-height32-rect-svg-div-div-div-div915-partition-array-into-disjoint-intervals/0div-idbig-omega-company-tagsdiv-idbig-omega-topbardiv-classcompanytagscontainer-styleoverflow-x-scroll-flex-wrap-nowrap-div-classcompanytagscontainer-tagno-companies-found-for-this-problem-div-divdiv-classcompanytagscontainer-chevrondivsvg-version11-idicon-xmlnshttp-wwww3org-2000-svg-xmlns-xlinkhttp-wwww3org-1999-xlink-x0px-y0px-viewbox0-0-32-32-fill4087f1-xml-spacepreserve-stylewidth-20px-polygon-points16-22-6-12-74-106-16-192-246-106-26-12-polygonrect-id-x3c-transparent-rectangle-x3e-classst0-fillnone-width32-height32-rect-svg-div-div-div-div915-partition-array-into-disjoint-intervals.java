class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] minFromRight = new int[nums.length];
        minFromRight[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){
            minFromRight[i] = Math.min(nums[i],minFromRight[i+1]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length-1;i++){
            max = Math.max(max,nums[i]);
            if(max<=minFromRight[i+1]){
                return (i+1);
            }
        }
        return -1;
    }
}  