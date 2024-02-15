class Solution{
    public boolean validMountainArray(int[] arr){
        int n = arr.length;
        if(n<3){
            return false;
        }
        
        for(int i = 0;i<n-1;i++){
            if(arr[i] == arr[i+1]){
                return false;
            }
        }
        
        int peakIdx = findPeakIndex(arr);
        if(peakIdx == 0 || peakIdx == n-1){
            return false;
        }
        
        for(int i = 0;i<peakIdx;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        
        for(int i = peakIdx;i<n-1;i++){
            if(arr[i]<arr[i+1]){
                return false;
            }
        }
        return true;
    }
    
    public int findPeakIndex(int[] arr){
        int peak = 0;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>arr[peak]){
                peak = i;
            }
        }
        return peak;
    }
}