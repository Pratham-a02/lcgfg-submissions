class Solution{
    public int majorityElement(int[] nums){
        Integer mele = null;
        
        int count = 0;
        
        for(int ele:nums){
            if(count == 0){
                mele = ele;
                count = 1;
            }
            else if(ele == mele){
                count++;
            }
            else{
                count--;
            }
        }
        return mele;
    }
}