class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        int i = arr.length - 1;
        
        while(i>0){
            if(arr[i-1]>=arr[i]){
                i--;
            }else{
                break;
            }
        }
        
        if(i == 0){
            return -1;
        }
        
        int idx = i-1;
        
        int j = arr.length - 1;
        
        while(j>idx){
            if(arr[j]>arr[idx]){
                break;
            }
            j--;
        }
        
        swap(arr,idx,j);
        int left = i;
        int right = arr.length - 1;
        while(left<right){
            swap(arr,left,right);
            left++;
            right--;
        }
        
        String ans = new String(arr);
        long val = Long.parseLong(ans);
        return (val>Integer.MAX_VALUE?-1:(int)val);
    }
    
    public void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}