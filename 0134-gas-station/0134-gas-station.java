class Solution{
    public int canCompleteCircuit(int[] gas, int[] cost){
        int csum = 0;
        int osum = 0;
        int si = 0;
        
        for(int i = 0;i<gas.length;i++){
            csum += (gas[i]-cost[i]);
            osum += (gas[i]-cost[i]);
            
            if(csum<0){
                si = i+1;
                csum = 0;
            }
        }
        
        if(osum<0 || si == gas.length){
            return -1;
        }
        
        return si;
    }
}