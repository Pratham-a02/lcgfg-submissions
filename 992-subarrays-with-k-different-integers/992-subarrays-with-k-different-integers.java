class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArrWithDI(nums,k)-subArrWithDI(nums,k-1);
    }
    public int subArrWithDI(int[] nums,int k){
        int ans = 0;
        int left = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int right = 0;right<nums.length;right++){
            int num = nums[right];
            if(hm.containsKey(num)){
                hm.put(num,hm.get(num)+1);
            }
            else{
                hm.put(num,1);
            }
            
            while(left<=right && hm.size()>k){
                int rem = nums[left];
                hm.put(rem,hm.get(rem)-1);
                if(hm.get(rem) == 0){
                    hm.remove(rem);
                }
                left++;
            }
            if(hm.size()<=k){
                ans += right - left + 1;
            }
        }
        return ans;
    }
}