class Solution {
    public int pivotInteger(int n) {
        int lo = 1;
        int hi = n;
        
        while(lo<=hi){
            int mid = (lo+hi)/2;
            
            int fs = (mid*(mid+1))/2;
            int rl = (n-mid+1);
            int ss = (rl*(mid+n))/2;
            
            if(fs == ss){
                return mid;
            }
            else{
                if(fs<ss){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}