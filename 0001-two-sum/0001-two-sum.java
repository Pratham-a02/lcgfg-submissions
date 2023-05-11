class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int currVal = nums[i];
            int comp = target-currVal;
            
            if(hm.containsKey(comp)){
                int[] arr = {i,hm.get(comp)};
                return arr;
            }
            hm.put(currVal,i);
        }
        return new int[2];
    }
}