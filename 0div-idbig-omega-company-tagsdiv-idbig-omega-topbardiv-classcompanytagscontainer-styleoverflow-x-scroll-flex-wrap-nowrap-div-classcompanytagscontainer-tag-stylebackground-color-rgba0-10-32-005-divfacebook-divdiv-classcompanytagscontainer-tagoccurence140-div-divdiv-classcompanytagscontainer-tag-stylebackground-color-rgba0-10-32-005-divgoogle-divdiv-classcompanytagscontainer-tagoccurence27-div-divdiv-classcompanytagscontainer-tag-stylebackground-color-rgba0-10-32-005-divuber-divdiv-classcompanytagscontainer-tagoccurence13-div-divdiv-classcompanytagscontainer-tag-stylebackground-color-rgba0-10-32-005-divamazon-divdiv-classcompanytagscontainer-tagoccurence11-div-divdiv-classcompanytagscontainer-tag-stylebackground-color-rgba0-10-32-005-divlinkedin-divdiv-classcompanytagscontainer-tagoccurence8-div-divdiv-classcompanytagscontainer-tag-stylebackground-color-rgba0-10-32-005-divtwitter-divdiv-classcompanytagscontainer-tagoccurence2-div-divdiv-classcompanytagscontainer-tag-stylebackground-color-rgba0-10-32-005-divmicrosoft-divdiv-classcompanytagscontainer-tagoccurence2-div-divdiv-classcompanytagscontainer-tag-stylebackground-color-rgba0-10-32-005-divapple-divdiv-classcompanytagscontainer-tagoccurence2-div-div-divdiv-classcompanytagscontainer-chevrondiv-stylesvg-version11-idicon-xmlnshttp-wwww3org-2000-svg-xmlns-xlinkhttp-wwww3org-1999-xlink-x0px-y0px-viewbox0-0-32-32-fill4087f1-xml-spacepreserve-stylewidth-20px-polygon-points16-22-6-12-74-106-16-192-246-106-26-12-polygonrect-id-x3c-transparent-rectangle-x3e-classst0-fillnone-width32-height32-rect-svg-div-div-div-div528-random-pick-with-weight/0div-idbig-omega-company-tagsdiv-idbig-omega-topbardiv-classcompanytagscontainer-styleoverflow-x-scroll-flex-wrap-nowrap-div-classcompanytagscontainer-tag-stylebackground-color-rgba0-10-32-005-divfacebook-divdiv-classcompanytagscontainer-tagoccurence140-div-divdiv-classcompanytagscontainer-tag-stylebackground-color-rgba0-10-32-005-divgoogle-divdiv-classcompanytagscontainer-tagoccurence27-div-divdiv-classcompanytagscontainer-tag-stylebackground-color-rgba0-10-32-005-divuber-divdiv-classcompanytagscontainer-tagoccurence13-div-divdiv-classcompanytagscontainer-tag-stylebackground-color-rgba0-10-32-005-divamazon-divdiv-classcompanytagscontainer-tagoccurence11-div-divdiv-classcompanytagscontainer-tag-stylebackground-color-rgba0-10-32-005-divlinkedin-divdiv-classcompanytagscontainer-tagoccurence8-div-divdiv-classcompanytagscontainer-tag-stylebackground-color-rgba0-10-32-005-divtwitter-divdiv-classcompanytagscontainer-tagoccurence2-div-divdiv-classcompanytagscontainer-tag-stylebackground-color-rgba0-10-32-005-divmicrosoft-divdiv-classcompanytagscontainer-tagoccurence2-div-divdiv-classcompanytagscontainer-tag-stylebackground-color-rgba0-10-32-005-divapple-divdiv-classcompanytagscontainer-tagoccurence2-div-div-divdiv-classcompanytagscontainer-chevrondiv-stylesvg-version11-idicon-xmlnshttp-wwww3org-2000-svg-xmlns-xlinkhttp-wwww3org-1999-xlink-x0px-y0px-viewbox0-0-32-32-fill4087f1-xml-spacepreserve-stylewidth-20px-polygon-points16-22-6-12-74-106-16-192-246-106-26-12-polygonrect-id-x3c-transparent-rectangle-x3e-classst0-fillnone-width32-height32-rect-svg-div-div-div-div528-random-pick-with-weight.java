class Solution {
    int[] sum;
    Random random = new Random();
    int max = 0;
    public Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        
        for(int i = 1;i<sum.length;i++){
            sum[i] = w[i] + sum[i-1];
        }
        
        max = sum[sum.length-1];
    }
    
    public int pickIndex() {
        int lo = 0;
        int hi = sum.length-1;
        int target = 1 + random.nextInt(max);
        
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(sum[mid] == target){
                return mid;
            }
            
            if(sum[mid]>target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */