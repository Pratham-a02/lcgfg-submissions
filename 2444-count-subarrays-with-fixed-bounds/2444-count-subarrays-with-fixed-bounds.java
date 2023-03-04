class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minFound = 0;
        int maxFound = 0;
        int start = 0;
        int minStart = -1;
        int maxStart = -1;
        
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            if(num<minK || num>maxK){
                start = i+1;
                minFound = -1;
                maxFound = -1;
            }
            if(num == minK){
                minFound = 1;
                minStart = i;
            }
            if(num == maxK){
                maxFound = 1;
                maxStart = i;
            }
            
            if(maxFound == 1 && minFound == 1){
                count += Math.min(minStart,maxStart) - start + 1;
            }
        }
        return count;
    }
}