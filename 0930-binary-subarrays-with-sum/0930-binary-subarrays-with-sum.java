class Solution{
    public int numSubarraysWithSum(int[] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ps = 0;
        hm.put(ps,1);
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            ps += nums[i];
            if(hm.containsKey(ps-k)){
                ans += hm.get(ps-k);
            }
            hm.put(ps,hm.getOrDefault(ps,0)+1);
        }
        return ans;
    }
}