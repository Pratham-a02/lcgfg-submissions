class Solution{
    public int findLengthOfShortestSubarray(int[] arr){
        int n = arr.length;
        
        int s = 0;
        int e = n-1;
        
        while(s<n-1 && arr[s]<=arr[s+1]){
            s++;
        }
        if(s == n-1) return 0;
        while(e>=s && arr[e]>=arr[e-1]){
            e--;
        }
        if(e == 0) return (n-1);
        
        int res = Math.min(e,n-s-1);
        
        int i = 0;
        int j = e;
        
        while(i<=s && j<n){
            if(arr[i]<=arr[j]){
                res = Math.min(res,j-i-1);
                i++;
            }
            else{
                j++;
            }
        }
        return res;
    }
}