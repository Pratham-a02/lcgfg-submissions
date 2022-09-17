class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++){
            
            if(i - 1 >= 0 && (nums[i - 1] == nums[i] - 1 || nums[i - 1] == nums[i])){
                continue;
            }
            
            if(i + 1 < n && (nums[i + 1] == nums[i] + 1 || nums[i + 1] == nums[i])){
                continue;
            }
            result.add(nums[i]);
        }
        return result;
    }
}