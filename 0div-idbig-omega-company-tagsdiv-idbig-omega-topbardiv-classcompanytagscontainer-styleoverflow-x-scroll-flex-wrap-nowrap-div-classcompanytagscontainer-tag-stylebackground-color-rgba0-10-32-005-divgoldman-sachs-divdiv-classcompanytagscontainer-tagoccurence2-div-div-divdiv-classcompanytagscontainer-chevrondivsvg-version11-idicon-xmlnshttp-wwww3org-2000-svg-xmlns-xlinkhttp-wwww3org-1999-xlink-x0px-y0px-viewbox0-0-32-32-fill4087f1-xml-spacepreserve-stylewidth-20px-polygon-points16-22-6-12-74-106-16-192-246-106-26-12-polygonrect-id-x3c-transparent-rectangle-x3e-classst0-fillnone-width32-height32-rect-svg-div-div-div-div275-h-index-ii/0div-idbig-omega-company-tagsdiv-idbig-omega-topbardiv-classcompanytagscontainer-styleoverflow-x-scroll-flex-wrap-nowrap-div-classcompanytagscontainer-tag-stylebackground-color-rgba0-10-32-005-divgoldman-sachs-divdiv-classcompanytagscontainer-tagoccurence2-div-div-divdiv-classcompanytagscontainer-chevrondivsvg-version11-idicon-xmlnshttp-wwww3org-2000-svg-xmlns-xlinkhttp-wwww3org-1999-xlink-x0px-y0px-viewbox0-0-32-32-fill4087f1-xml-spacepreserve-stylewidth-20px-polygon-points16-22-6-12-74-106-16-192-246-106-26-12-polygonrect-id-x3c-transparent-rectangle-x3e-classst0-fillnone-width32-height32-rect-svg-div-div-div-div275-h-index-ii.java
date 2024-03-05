class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lo = 0;
        int hi = citations.length-1;
        int ans = 0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            
            if((n-mid)==citations[mid]){
                return (n-mid);
            }
            else if(citations[mid]>(n-mid)){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return n-lo;
    }
}