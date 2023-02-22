class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        int max = Integer.MIN_VALUE;
        for(int weight:weights){
            max = Math.max(max,weight);
            hi += weight;
        }
        lo = max;
        while(lo<hi){
            int mid = lo - (lo-hi)/2;
            int alsum = mid;
            
            int currsum = 0;
            int partition = 1;
            for(int weight:weights){
                if(currsum + weight<=alsum)
                    currsum += weight;
                else{
                    partition++;
                    currsum = weight;
                }
            }
            if(partition<=days){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        return lo;
    }
}