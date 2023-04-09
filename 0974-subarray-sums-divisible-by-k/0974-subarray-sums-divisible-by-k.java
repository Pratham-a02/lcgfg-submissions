class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        hm.put(0,1);
        int ps = 0;
        for(int i = 0;i<nums.length;i++){
            ps += nums[i];
            
            int rem = ((ps%k)+k)%k;
            if(hm.containsKey(rem)){
                ans += hm.get(rem);
            }
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}