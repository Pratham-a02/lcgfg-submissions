class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
                idx = i;
            }
        }
        
        int smax = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>smax){
                if(nums[i]<max){
                    smax = nums[i];
                }
            }
        }
        
        if(max>=smax*2){
            return idx;
        }
        else{
            return -1;
        }
    }
}