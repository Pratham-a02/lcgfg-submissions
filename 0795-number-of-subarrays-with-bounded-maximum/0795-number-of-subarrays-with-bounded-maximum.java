class Solution{
    public int numSubarrayBoundedMax(int[] nums,int left,int right){
        int si = -1;
        int ei = -1;
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            int val = nums[i];
            
            if(val <= right && val >= left){
                ei = i;
                ans +=(ei-si);
            }
            else if(val > right){
                si = ei = i;
            }
            else if(val<left){
                ans +=(ei-si);
            }
        }
        return ans;
    }
}