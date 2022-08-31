class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int ps = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(ps,1);
        for(int i = 0;i<nums.length;i++){
            ps += nums[i];
            if(hm.containsKey(ps-k)){
                count += hm.get(ps-k);
            }
            
                hm.put(ps,hm.getOrDefault(ps,0)+1);
            
        }
        return count;
    }
}