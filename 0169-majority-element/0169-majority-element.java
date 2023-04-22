class Solution{
    public int majorityElement(int[] nums){
        Integer mele = null;
        
        int count = 0;
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