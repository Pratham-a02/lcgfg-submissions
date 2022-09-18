class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        int left = 0;
        int ps = 0;
        
        for(int right = 0;right<nums.length;right++){
            
            if(hm.containsKey(nums[right])){
                while(hm.containsKey(nums[right])){
                    ps = ps-nums[left];
                    hm.put(nums[left],hm.get(nums[left])-1);
                    if(hm.get(nums[left]) == 0){
                        hm.remove(nums[left]);
                    }
                    left++;
                }
            }
            ps += nums[right];
            hm.put(nums[right],1);
            max = Math.max(max,ps);
        }
        return max;
    }
}