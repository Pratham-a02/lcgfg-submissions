class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int start = 0;
        int minStart = -1;
        int maxStart = -1;
        int minFound = 0;
        int maxFound = 0;
        long count = 0;
        
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            
            if(num<minK || num>maxK){
                start = i+1;
                minFound = -1;
                maxFound = -1;
            }
            if(num == minK){
                minStart = i;
                minFound = 1;
            }
            if(num == maxK){
                maxStart = i;
                maxFound = 1;
            }
            
            if(minFound == 1 && maxFound == 1){
                count += (Math.min(minStart,maxStart) - start + 1);
            }
        }
        return count;
    }
}