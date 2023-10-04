class Solution{
    public int numberOfSubarrays(int[] nums,int k){
        int count = 0;
        for(int right = 0;right<nums.length;right++){
            if(nums[right]%2 == 1){
                nums[right] = 1;
            }
            else{
                nums[right] = 0;   
            }
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int ps = 0;
        
        for(int i = 0;i<nums.length;i++){
            ps += nums[i];
            
            if(hm.containsKey(ps-k)){
                count+= hm.get(ps-k);
            }
            
            hm.put(ps,hm.getOrDefault(ps,0)+1);
        }
        return count;
    }
}