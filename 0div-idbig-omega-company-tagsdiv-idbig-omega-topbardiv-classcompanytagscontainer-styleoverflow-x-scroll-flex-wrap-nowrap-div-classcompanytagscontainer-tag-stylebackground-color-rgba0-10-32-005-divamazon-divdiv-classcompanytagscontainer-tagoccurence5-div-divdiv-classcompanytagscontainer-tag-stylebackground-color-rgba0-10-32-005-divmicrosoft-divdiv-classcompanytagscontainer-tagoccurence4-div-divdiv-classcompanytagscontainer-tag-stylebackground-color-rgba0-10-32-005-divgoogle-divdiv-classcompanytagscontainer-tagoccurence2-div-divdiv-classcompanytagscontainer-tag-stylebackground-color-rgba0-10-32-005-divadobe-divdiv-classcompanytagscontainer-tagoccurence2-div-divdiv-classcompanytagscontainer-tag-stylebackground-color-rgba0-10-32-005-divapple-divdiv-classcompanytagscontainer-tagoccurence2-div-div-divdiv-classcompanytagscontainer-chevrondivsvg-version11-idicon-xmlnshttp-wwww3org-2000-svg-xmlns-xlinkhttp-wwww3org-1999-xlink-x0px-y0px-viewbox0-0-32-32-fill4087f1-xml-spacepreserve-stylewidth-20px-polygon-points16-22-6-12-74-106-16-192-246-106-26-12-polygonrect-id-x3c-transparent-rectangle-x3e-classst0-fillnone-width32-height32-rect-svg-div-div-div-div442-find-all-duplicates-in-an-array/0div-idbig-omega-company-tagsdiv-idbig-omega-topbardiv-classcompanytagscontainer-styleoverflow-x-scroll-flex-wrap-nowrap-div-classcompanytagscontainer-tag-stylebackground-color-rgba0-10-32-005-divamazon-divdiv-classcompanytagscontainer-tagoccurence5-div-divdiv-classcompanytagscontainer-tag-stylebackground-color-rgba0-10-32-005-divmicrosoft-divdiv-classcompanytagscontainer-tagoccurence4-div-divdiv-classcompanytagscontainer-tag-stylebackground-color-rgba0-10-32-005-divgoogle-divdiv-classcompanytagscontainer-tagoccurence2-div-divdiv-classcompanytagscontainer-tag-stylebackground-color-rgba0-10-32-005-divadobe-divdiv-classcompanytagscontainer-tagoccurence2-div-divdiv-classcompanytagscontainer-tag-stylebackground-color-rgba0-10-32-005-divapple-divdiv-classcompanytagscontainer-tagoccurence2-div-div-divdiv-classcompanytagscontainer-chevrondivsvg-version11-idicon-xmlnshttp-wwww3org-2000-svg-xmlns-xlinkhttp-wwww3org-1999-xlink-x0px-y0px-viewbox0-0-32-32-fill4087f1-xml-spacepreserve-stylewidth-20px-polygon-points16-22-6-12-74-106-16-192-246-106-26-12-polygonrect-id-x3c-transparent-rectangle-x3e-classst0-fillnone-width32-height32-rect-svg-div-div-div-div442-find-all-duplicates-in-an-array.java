class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            
            int idx = val-1;
            if(nums[idx]>0){
                nums[idx] = -1*nums[idx];
            }
            else{
                ans.add(val);
            }
        }
        
        return ans;
    }
}