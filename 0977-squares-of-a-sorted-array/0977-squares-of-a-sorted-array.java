class Solution {
    public int[] sortedSquares(int[] nums){
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int idx = ans.length - 1;
        while(idx>=0){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                ans[idx] = nums[left]*nums[left];
                left++;
            }
            else{
                ans[idx] = nums[right]*nums[right];
                right--;
            }
            
            idx--;
        }
        
        return ans;
    }
    
   
}