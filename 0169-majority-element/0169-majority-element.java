class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer mele = null;
        
        for(int i = 0;i<nums.length;i++){
            if(count == 0){
                mele = nums[i];
                count = 1;
            } 
            else if(nums[i] == mele){
                count++;
            }
            else{
                count--;
            }
        }
        return mele;
    }
}