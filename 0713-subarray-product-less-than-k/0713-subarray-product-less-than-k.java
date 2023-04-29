class Solution{
    public int numSubarrayProductLessThanK(int[] nums,int k){
        if(k == 0){
            return 0;
        }
        int pm = 1;
        int count = 0;
        int left = 0;
        
        for(int right = 0;right<nums.length;right++){
            pm = pm*nums[right];
            
            while(left<nums.length && pm >= k){
                pm = pm/nums[left];
                left++;
            }
            
            if(pm<k){
                count += (right - left + 1);
            }
        }
        
        return count;
    }
}