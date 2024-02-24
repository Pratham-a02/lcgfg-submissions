class Solution{
    public int pivotIndex(int[] nums){
        int[] ps = new int[nums.length+1];
        int[] ss = new int[nums.length+1];
        
        ps[0] = 0;
        ss[ss.length-1] = 0;
        
        int cs = 0;
        
        for(int i = 0;i<nums.length;i++){
            cs += nums[i];
            ps[i+1] = cs;
        }
        cs = 0;
        for(int i = nums.length-1;i>=0;i--){
            cs += nums[i];
            ss[i] = cs;
        }
        
        for(int i = 0;i<ps.length-1;i++){
            if(ps[i] == ss[i+1]){
                return i;
            }
        }
        return -1;
    }
}