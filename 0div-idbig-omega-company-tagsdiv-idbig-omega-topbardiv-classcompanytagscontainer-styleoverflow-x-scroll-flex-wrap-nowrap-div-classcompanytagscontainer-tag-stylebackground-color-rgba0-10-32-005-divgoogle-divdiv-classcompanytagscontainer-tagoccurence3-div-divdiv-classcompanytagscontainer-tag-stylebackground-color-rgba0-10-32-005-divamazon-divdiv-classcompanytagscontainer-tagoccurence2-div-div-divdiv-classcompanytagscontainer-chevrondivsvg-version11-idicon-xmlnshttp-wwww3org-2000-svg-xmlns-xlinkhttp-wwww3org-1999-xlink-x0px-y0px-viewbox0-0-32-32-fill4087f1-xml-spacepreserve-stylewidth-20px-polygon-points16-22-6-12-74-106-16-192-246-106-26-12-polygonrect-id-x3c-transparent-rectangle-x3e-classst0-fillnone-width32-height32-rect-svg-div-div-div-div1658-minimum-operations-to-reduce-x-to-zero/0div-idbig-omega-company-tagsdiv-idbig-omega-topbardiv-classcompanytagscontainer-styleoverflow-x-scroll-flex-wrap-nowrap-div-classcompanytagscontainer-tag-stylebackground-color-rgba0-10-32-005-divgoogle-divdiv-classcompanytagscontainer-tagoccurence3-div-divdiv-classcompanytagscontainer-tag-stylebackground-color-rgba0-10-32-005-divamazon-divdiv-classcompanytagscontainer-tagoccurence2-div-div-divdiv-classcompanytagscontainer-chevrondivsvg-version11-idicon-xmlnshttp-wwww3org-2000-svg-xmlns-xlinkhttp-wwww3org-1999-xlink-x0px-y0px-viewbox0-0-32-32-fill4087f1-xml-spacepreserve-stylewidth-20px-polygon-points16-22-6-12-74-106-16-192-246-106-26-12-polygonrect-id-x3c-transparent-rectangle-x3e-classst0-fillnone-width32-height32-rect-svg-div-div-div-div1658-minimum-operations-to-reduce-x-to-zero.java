class Solution {
    public int minOperations(int[] nums, int x) {
        int ps = 0;
        int total = 0;
        for(int val : nums){
            total += val;
        }
        int k = total - x;
        if(k == 0) return nums.length;
        int max = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        
        for(int i = 0;i<nums.length;i++){
            ps += nums[i];
            
            if(hm.containsKey(ps - k)){
                max = Math.max(max,i-hm.get(ps-k));
            }
            
            hm.put(ps,i);
        }
        if(max == 0)return -1;
        return nums.length - max;
    }
}