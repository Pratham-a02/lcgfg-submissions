class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>hashSet = new HashSet<Integer>();
        for(int num : nums){
            hashSet.add(num);
        }
        int longestLength = 0;
        for(int num : nums){
            if(!hashSet.contains(num-1)){
                int curNum = num;
                int countLength = 1;

                while(hashSet.contains(curNum + 1)){
                    curNum += 1;
                    countLength += 1;
                }
                longestLength = Math.max(longestLength, countLength);
            }
        }
        return longestLength;
    }
}