class Solution{
    public int maxSubarraySumCircular(int[] a) {
        int n = a.length;
        int total = 0;
        for(int val:a){
            total += val;
        }
        
        int noCircular = kadaneAlgo(a,n);
        int circular = total - (minKadane(a,n));
        if(circular == 0){
            return noCircular;
        }
        return Math.max(noCircular, circular);
    }
    
    public static int kadaneAlgo(int[] a,int n){
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i = 0;i<n;i++){
            curr += a[i];
            max = Math.max(max,curr);
            if(curr<0){
                curr = 0;
            }
        }
        return max;
    }
    
    public static int minKadane(int[] a,int n){
        int min = Integer.MAX_VALUE;  
        int curr = 0;
        for(int i = 0;i<n;i++){
            curr += a[i];
            min = Math.min(min,curr);
            if(curr>0){
                curr = 0;
            }
        }
        return min;
    }
}