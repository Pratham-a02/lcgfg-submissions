class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        
        for(int i = nums.length-1;i>=0;i--){
            int lo = 0;
            int hi = i-1;
            while(lo<hi){
                if(nums[lo]+nums[hi]>nums[i]){
                    count++;
                    count += (hi-lo-1);
                    hi--;
                }
                else{
                    lo++;
                }
            }
        }
        return count;
    }
}