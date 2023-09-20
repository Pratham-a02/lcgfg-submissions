class Solution {
    public int majorityElement(int[] nums) {
        Integer mele = null;
        int count = 0;
        
        for(int num : nums){
            if(count == 0){
                mele = num;
                count = 1;
            }
            else if(num == mele){
                count++;
            }
            else{
                count--;
            }
        }
        return mele;
    }
}