class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int val = nums[i];
            int idx = Math.abs(val);
            if(nums[idx-1]<0){
                ans.add(idx);
            }
            nums[idx-1] = -1*nums[idx-1];
        }
        return ans;
    }
}