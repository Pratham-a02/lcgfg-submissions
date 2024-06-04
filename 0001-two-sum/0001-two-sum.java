class Solution{
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int val = nums[i];
            
            if(hm.containsKey(target-val)){
                return new int[]{i,hm.get(target-val)};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }
}