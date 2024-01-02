class Solution{
    public int maxChunksToSorted(int[] arr){
        int[] mfl = new int[arr.length];
        mfl[0] = arr[0];
        for(int i = 1;i<arr.length;i++){
            mfl[i] = Math.max(arr[i],mfl[i-1]);
        }
        
        int count = 0;
        
        for(int i = 0;i<arr.length;i++){
            if(mfl[i] == i){
                count++;
            }
        }
        return count;
    }
}