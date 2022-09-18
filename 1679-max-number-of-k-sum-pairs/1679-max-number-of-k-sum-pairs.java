class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(hm.containsKey(k - nums[i]) && hm.get(k-nums[i])>0){
                count++;
                hm.put(k-nums[i],hm.get(k-nums[i])-1);
            }
            else{
                hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }
}