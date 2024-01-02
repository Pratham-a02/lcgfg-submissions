class Solution{
    public int nextGreaterElement(int n){
        char[] arr = (n+"").toCharArray();
        
        int i = arr.length - 2;
        
        while(i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        if(i<0) return -1;
        
        int idx = i;
        int j = arr.length - 1;
        
        while(j>idx){
            if(arr[j]>arr[idx]){
                break;
            }
            else{
                j--;
            }
        }
        
        swap(i,j,arr);
        reverse(i+1,arr.length-1,arr);
        
        String val = String.valueOf(arr);
        long ans = Long.parseLong(val);
    
        return (ans>Integer.MAX_VALUE?-1:(int)ans);
    }
    
    public void swap(int i,int j,char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void reverse(int i,int j,char[] arr){
        while(i<=j){
            swap(i,j,arr);
            i++;
            j--;
        }
    }
    
    
}