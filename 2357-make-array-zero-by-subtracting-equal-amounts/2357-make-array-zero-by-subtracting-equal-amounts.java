class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        if(nums.length == 1 && nums[0] == 0) return 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                continue;
            }
            else{
            hs.add(nums[i]);
            }
        }
        
        return hs.size();
    }
}