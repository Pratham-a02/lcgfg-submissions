class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k) - func(nums,k-1);
    }
    
    public int func(int[] nums,int k){
        int left = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        
        for(int right = 0;right<nums.length;right++){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);
            
            while(hm.size()>k){
                hm.put(nums[left],hm.get(nums[left])-1);
                if(hm.get(nums[left]) == 0){
                    hm.remove(nums[left]);
                }
                left++;
            }
            
            if(hm.size()<=k){
                count += (right - left + 1);
            }
        }
        return count;
    }
}