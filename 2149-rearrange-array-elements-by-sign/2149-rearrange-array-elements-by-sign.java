class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        
        int idx = 0;
        int pi = 0;
        int ni = 1;
        
        while(pi<ans.length && ni<ans.length){
            if(nums[idx]>0){
                ans[pi] = nums[idx];
                pi+=2;
            }
            else{
                ans[ni] = nums[idx];
                ni+=2;
            }
            idx++;
        }
        
        while(pi<nums.length){
            ans[pi] = nums[idx];
            pi+=2;
            idx++;
        }
        
        while(ni<nums.length){
            ans[ni] = nums[idx];
            ni+=2;
            idx++;
        }
        
        return ans;
    }
}