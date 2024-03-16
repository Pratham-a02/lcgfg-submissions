class Solution{
    public int findMaxLength(int[] nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int ps = 0;
        int max = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                ps++;
            }
            else{
                ps--;
            }
            
            if(hm.containsKey(ps)){
                max = Math.max(max,i-hm.get(ps));
            }
            else{
                hm.put(ps,i);
            }
        }
        return max;
    }
}