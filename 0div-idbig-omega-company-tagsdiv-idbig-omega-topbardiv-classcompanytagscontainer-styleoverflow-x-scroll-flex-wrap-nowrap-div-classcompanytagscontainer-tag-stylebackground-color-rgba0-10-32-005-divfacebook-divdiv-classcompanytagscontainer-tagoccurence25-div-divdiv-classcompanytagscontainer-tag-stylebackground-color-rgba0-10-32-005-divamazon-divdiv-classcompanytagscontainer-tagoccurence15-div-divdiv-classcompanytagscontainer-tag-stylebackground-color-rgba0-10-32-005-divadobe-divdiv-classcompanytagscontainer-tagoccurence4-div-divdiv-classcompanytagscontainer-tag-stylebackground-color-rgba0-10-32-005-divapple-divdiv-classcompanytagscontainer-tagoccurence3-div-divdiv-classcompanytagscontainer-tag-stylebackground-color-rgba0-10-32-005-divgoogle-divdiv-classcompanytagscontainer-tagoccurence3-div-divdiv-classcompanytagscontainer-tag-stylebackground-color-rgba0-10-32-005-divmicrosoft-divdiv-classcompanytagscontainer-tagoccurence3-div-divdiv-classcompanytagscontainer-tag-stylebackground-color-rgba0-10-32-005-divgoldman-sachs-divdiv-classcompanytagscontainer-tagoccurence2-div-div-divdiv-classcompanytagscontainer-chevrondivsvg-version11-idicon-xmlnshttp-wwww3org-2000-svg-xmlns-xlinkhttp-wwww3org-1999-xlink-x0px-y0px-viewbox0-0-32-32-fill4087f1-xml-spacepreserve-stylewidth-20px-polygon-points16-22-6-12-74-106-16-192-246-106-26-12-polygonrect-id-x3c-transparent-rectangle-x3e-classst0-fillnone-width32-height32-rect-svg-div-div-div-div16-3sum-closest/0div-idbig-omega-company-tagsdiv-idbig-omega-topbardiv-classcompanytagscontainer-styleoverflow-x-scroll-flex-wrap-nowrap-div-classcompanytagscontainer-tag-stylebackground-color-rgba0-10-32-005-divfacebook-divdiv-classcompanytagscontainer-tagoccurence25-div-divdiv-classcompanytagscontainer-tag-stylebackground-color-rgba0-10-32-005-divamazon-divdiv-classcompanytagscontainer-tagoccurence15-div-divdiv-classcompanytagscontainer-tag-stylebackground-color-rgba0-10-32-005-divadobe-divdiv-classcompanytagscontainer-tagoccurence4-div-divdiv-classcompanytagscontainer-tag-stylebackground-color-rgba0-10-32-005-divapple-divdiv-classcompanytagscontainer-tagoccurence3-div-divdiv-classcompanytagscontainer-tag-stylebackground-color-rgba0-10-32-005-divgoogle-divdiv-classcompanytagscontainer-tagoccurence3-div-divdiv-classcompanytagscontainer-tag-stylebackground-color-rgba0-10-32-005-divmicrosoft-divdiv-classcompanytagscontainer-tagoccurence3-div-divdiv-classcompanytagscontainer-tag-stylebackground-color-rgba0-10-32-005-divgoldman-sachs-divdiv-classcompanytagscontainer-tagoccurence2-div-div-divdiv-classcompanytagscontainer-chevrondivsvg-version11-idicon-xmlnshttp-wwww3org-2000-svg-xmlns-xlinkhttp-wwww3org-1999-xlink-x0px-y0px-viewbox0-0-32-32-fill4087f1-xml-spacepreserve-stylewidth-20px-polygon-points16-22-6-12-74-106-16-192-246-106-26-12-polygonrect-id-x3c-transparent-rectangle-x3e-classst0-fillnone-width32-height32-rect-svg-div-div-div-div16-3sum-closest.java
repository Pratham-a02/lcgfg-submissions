class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 100000;
        
        for(int i = 0;i<n;i++){
            int val = nums[i];
            
            int lo = i+1;
            int hi = n-1;
            
            while(lo<hi){
                int currSum = val + nums[lo] + nums[hi];
                
                if(Math.abs(target-currSum) < Math.abs(target-ans)){
                    ans = currSum;
                }
                if(currSum > target){
                    hi--;
                }
                else{
                    lo++;
                }
            }
        }
        return ans;
    }
}