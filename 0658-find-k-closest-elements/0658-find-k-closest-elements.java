class Solution{
    public List<Integer> findClosestElements(int[] arr,int k,int x){
        int lo = 0;
        int hi = arr.length-1;
        List<Integer> ans = new ArrayList<>();
        
        while(hi-lo>=k){
            int val1 = Math.abs(arr[lo]-x);
            int val2 = Math.abs(arr[hi]-x);
            
            if(val1>val2){
                lo++;
            }
            else{
                hi--;
            }
        }
        
        for(int i = lo;i<=hi;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}