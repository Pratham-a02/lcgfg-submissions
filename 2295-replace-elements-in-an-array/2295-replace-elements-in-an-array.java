class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        for(int i = 0;i<operations.length;i++){
            int oldVal = operations[i][0];
            int newVal = operations[i][1];
            if(hm.containsKey(oldVal)){
                int idx = hm.get(oldVal);
                nums[idx] = newVal;
                hm.put(newVal,idx);
            }
        }
        return nums;
    }
}