class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ps = 0;
        hm.put(ps,1);
        for(int i = 0;i<nums.length;i++){
            ps += nums[i];
            ps = ((ps%k)+k)%k;
            if(hm.containsKey(ps)){
                ans += hm.get(ps);
                hm.put(ps,hm.get(ps)+1);
            }
            else{
                hm.put(ps,1);
            }
        }
        return ans;
    }
}