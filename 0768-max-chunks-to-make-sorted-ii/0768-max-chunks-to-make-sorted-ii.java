class Solution{
    public int maxChunksToSorted(int[] arr){
        int n = arr.length;
        int[] minfromright = new int[arr.length];
        minfromright[n-1] = arr[n-1];
        
        for(int i = n-2;i>=0;i--){
            minfromright[i] = Math.min(arr[i],minfromright[i+1]);
        }
        
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length-1;i++){
            max = Math.max(max,arr[i]);
            if(max <= minfromright[i+1]){
                count++;
            }
        }
        return count+1;
    }
}