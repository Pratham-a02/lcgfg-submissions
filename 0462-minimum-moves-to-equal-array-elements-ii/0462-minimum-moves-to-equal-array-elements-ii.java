class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int li = 0;
        int ri = nums.length-1;
        int ans = 0;
        while(li<ri){
            ans += Math.abs(nums[ri--]-nums[li++]);
        }
        
        return ans;
    }
}