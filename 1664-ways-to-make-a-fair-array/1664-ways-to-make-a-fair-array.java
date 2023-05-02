class Solution{
    public int waysToMakeFair(int[] nums){
        int n = nums.length;
        int[] esum = new int[n];
        int[] osum = new int[n];
        
        int es = 0;
        int os = 0;
        
        for(int i = 0;i<n;i++){
            if(i%2 == 0){
                es += nums[i];
            }
            else{
                os += nums[i];
            }
            
            esum[i] = es;
            osum[i] = os;
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(i == 0){
                int nes = esum[n-1] - esum[0];
                int nos = osum[n-1];
                
                if(nes == nos)count++;
                continue;
            }
            
            int nes = esum[i-1] + (osum[n-1]-osum[i]);
            int nos = osum[i-1] + (esum[n-1]-esum[i]);
            
            if(nes == nos)count++;
        }
        
        return count;
    }
}