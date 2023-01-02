class Solution {
    public int partitionDisjoint(int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] minfromright = new int[nums.length];
        minfromright[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){
            min = Math.min(min,nums[i]);
            minfromright[i] = min;
        }
        
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length-1;i++){
            max = Math.max(max,nums[i]);
            
            if(max<=minfromright[i+1]){
                ans = i+1;
                break;
            }
        }
        return ans;
    }
}