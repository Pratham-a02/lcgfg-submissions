class Solution {
    public long maxAlternatingSum(int[] nums) {
        return maxSum(0,1,nums,new HashMap<String,Long>());
    }
    public long maxSum(int currIdx,int flag,int[] nums,HashMap<String,Long>hm){
        if(currIdx  >= nums.length){
            return 0;
        }
        
        String currKey = currIdx + "_" + flag;
        
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        if(flag == 1){
            long taken = nums[currIdx] + maxSum(currIdx+1,0,nums,hm);
            long notTaken = maxSum(currIdx+1,1,nums,hm);
            hm.put(currKey,Math.max(taken,notTaken));
            return Math.max(taken,notTaken);
        }
        else{
            long taken = -nums[currIdx] + maxSum(currIdx+1,1,nums,hm);
            long notTaken = maxSum(currIdx+1,0,nums,hm);
            hm.put(currKey,Math.max(taken,notTaken));
            return Math.max(taken,notTaken);
        }
    }
}