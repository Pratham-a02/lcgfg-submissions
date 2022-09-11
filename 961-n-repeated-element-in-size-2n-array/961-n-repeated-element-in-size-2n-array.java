class Solution {
    public int repeatedNTimes(int[] nums) {
        if(nums.length%2 != 0){
            return 0;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        int fans = nums.length/2;
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(int val:hm.keySet()){
            if(hm.get(val) == fans){
                return val;
            }
        }
        return 0;
    }
}