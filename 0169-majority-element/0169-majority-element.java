class Solution {
    public int majorityElement(int[] nums) {
        Integer mele = null;
        int freq = 0;
        
        for(int num : nums){
            if(freq == 0){
                mele = num;
                freq = 1;
            }
            else if(num == mele){
                freq++;
            }
            else if(num != mele){
                freq--;
            }
        }
        return mele;
    }
}