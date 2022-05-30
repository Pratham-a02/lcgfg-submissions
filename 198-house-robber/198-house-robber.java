class Solution {
    public int rob(int[] nums) {
        return maxMoney(nums,0,new HashMap<Integer,Integer>());
    }
    
    private int maxMoney(int[] nums,int idx,HashMap<Integer,Integer>hm){
        if(idx>= nums.length){
            return 0;
        }
        
        int currKey = idx;
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        int pathTaken = nums[idx] + maxMoney(nums,idx+2,hm);
        int pathNotTaken = maxMoney(nums,idx+1,hm);
        
        hm.put(currKey,Math.max(pathTaken,pathNotTaken));
        
        return Math.max(pathTaken,pathNotTaken);
    }
    
}