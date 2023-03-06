class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo<=hi){
            int mid = (lo+hi)/2;
            
            int mn = arr[mid] - (mid+1);
            if(mn>=k){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        if(hi == -1){
            return k;
        }
        else{
            return arr[hi] + k - (arr[hi] - (hi+1));
        }
    }
}