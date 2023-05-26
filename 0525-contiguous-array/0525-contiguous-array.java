class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int ps = 0;
        for(int i = 0;i<nums.length;i++){
            int currVal = nums[i];
            
            if(currVal == 1){
                ps = ps+1;
            }
            if(currVal == 0){
                ps = ps-1;
            }
            
            if(hm.containsKey(ps)){
                ans = Math.max(ans,i-hm.get(ps));
            }
            if(!hm.containsKey(ps)){
                hm.put(ps,i);
            }
        }
        return ans;
    }   
}