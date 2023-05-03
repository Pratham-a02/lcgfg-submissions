class Solution {
    public int maximumSwap(int num) {
        char[] arr = (num + "").toCharArray();
        int n = arr.length;
        int[] right = new int[arr.length];
        
        for(int i = n-1;i>=0;i--){
            if(i == n-1){
                right[i] = -1;
            }
            else if(i == n-2){
                right[i] = n-1;
            }
            else{
                if(arr[i+1] > arr[right[i+1]]){
                    right[i] = i+1;
                }
                else{
                    right[i] = right[i+1];
                }
            }
        }
        
        for(int i = 0;i<n-1;i++){
            if(arr[i] < arr[right[i]]){
                char temp = arr[i];
                arr[i] = arr[right[i]];
                arr[right[i]] = temp;
                break;
            }
        }
        
        return Integer.parseInt(new String(arr));
    }
}