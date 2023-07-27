class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int num:nums){
            hs.add(num);
        }
        
        int longestLength = 0;
        for(int num:nums){
            if(!hs.contains(num-1)){
                int currNum = num;
                int currLen = 1;
                
                while(hs.contains(currNum+1)){
                    currNum++;
                    currLen++;
                }
                            
                longestLength = Math.max(longestLength,currLen);
            }
        }
        return longestLength;
    }
}