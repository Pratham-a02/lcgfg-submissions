class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        if(n == 0){
            return true;
        }
        if(nums.length == 1){
            if(nums[0] == 1){
                if(n == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(nums[0] == 0){
                if(n<=1){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(i == 0){
                if(nums[i] == 0 && i+1<nums.length && nums[i+1] == 0){
                    nums[i] = 1;
                    count++;
                }
            }
            else if(i == nums.length - 1 && nums[i] == 0){
                if(i-1>= 0 && nums[i - 1] == 0){
                    count++;
                    nums[i] = 1;
                }
            }
            else{
                if(nums[i] == 0){
                    if((i-1>=0 && nums[i-1] == 0) && (i+1<nums.length && nums[i+1] == 0)){
                        nums[i] = 1;
                        count++;
                    }
                }
            }
            
            if(count == n){
                return true;
            }
        }        
    
        return count == n;
        
    }
}