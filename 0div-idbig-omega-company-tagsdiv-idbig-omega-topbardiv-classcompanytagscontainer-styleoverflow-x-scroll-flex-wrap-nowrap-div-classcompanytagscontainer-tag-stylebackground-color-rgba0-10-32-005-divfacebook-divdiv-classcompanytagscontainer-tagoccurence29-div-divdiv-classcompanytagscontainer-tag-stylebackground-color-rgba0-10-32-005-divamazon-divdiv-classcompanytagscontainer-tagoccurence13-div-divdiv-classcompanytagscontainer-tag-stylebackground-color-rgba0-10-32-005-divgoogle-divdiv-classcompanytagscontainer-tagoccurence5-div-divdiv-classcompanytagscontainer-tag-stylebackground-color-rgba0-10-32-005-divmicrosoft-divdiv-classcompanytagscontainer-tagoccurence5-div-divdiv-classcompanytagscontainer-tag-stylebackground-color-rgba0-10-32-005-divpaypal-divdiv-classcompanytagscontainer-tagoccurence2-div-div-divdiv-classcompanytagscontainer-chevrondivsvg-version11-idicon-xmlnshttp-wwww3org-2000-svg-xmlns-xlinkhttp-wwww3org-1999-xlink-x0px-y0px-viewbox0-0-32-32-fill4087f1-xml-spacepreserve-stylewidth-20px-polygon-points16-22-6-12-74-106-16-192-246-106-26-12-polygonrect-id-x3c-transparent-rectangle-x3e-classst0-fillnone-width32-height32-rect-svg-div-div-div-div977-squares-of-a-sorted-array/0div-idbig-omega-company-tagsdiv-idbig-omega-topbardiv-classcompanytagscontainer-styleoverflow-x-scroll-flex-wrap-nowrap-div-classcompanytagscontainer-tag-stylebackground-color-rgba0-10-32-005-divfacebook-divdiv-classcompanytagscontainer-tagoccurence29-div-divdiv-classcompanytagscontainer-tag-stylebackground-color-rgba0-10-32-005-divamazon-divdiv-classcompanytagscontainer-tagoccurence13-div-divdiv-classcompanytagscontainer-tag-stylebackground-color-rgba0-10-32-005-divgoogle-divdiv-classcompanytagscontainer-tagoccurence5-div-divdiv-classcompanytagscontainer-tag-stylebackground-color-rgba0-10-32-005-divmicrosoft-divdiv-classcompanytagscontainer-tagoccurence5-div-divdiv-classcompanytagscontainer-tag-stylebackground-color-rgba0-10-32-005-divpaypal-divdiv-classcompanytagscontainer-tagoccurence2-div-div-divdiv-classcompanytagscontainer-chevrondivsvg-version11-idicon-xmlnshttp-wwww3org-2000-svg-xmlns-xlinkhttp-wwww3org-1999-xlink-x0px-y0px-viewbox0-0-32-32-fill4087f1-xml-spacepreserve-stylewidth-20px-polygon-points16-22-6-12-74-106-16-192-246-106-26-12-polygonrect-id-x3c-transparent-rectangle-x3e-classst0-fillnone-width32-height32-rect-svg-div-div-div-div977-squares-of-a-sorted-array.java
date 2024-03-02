class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        int k = nums.length-1;
        
        while(i<=j){
            if(Math.abs(nums[i]) >= Math.abs(nums[j])){
                int val = nums[i]*nums[i];
                ans[k] = val;
                i++;
                k--;
            }
            else if(Math.abs(nums[j])>Math.abs(nums[i])){
                int val = nums[j]*nums[j];
                ans[k] = val;
                j--;
                k--;
            }
        }
        
        return ans;
    }
}