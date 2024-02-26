class Solution{
    public boolean containsNearbyAlmostDuplicate(int[] nums,int indexDiff,int valueDiff){
        TreeSet<Long> hs = new TreeSet<>();
        
        for(int i = 0;i<nums.length;i++){
            Long el = new Long(nums[i]);
            
            Long ceil = hs.ceiling(el);
            Long floor = hs.floor(el);
            
            if(ceil != null && Math.abs(ceil-el)<=valueDiff){
                return true;
            }
            if(floor != null && Math.abs(floor-el) <= valueDiff){
                return true;
            }
            hs.add(el);
            if(hs.size()>indexDiff){
                hs.remove(new Long(nums[i-indexDiff]));
            }
        }
        return false;
    }
}