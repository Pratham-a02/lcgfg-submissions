class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        long max = 0;
        int left = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int right = 0;right<nums.length;right++){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);
            if(hm.get(nums[right])>k){
                while(hm.get(nums[right])>k){
                    hm.put(nums[left],hm.get(nums[left])-1);
                    left++;
                }
            }
            
            max = Math.max(max,right-left+1);
        }
        return (int)max;
    }
}