class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        
        for(int i = 0;i<nums.length;i++){
            int val = nums[i];
            
            if(hm.containsKey(val)){
                count += hm.get(val);
                hm.put(val,hm.get(val)+1);
            }
            else{
                hm.put(val,1);
            }
        }
        return count;
    }
}