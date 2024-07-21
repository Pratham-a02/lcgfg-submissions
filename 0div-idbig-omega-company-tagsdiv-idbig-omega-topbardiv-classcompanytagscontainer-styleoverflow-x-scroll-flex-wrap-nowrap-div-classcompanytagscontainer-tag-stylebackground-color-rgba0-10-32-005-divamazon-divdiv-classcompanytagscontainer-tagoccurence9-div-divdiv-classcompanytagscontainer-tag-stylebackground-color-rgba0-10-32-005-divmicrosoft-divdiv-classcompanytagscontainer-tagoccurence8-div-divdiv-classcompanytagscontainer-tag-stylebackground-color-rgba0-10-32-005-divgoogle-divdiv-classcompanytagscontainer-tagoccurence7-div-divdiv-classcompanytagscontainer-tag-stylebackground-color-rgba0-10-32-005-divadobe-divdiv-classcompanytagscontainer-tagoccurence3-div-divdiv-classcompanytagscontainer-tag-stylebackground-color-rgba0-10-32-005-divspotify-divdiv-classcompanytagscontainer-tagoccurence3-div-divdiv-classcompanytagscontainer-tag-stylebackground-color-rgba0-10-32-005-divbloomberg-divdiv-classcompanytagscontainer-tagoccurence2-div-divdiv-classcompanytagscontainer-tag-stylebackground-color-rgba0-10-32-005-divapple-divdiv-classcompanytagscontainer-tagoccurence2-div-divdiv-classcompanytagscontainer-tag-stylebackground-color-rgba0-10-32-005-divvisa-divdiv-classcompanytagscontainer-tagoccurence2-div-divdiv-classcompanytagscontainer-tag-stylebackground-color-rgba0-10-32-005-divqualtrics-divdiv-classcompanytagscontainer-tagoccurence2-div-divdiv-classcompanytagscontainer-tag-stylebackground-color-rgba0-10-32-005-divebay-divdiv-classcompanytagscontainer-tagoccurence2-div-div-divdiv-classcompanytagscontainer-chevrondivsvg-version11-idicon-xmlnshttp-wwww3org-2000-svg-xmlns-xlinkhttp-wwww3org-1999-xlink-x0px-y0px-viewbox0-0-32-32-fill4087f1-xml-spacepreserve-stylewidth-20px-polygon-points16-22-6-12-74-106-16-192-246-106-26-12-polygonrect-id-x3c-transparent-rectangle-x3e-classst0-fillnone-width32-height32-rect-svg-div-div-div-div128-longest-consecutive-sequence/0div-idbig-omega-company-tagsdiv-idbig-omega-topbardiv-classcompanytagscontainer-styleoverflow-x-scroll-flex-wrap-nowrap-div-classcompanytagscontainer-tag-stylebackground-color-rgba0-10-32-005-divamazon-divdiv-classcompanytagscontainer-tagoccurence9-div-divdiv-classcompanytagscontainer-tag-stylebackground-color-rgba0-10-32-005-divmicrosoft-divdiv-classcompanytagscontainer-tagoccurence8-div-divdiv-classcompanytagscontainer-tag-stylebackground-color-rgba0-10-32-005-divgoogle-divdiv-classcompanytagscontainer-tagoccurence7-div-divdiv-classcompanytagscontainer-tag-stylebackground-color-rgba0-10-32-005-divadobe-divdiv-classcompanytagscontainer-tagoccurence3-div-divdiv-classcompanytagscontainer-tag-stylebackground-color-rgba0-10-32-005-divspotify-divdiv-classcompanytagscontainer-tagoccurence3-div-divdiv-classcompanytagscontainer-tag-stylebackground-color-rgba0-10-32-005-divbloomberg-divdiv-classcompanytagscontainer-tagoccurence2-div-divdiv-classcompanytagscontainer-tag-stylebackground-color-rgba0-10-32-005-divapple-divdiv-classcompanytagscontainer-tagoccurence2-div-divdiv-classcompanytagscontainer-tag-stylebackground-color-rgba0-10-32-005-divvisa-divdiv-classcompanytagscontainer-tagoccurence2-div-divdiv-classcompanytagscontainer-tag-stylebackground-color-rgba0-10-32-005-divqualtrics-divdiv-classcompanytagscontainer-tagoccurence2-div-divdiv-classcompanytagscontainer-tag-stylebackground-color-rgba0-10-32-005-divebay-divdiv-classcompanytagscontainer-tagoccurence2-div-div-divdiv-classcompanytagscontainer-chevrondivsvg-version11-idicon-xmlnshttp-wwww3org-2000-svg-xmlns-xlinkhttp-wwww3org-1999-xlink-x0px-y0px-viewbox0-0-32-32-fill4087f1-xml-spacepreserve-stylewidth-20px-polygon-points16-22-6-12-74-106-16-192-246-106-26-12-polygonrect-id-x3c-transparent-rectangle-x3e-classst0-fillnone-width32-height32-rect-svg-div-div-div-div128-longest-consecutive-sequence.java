class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            if(!hs.contains(num-1)){
                int currLen = 1;
                while(hs.contains(num+1)){
                    currLen++;
                    num++;
                }
                max = Math.max(max,currLen);
            }
        }
        return max;
    }
}