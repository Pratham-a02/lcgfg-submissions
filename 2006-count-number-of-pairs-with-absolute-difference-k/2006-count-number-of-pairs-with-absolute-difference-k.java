class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(hm.containsKey(nums[i]+k)){
                count += hm.get(nums[i]+k);
            }
            if(hm.containsKey(nums[i]-k)){
                count += hm.get(nums[i]-k);
            }
            
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}