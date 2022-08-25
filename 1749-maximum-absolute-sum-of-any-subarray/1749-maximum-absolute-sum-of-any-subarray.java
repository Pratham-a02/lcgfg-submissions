class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0;
        int box1 = 0;
        int box2 = 0;
        for(int i = 0;i<nums.length;i++){
            box1 += nums[i];
            box2 += nums[i];
            ans = Math.max(ans,Math.max(Math.abs(box1),Math.abs(box2)));
            
            if(box1<0){
                box1 = 0;
            }
            if(box2>0){
                box2 = 0;
            }
        }
        return ans;
    }
}