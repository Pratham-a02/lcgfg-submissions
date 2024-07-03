class Solution{
    public int minDifference(int[] nums){
        if(nums.length<=3) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(Math.min(nums[n-1]-nums[3],nums[n-4]-nums[0]),Math.min(nums[n-3]-nums[1],nums[n-2]-nums[2]));
    }
}