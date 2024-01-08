class Solution{
    public int numSubarrayBoundedMax(int[] nums,int left,int right){
        int si = -1;
        int ei = -1;
        int ans = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] >=left && nums[i]<=right){
                ei = i;
                ans += (ei-si);
            }
            else if(nums[i]<left){
                ans += (ei-si);
            }
            else if(nums[i]>right){
                si = ei = i;
            }
        }
        return ans;
    }
}