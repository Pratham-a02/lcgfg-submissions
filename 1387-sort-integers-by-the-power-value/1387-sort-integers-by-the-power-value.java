class Pair{
    int idx;
    int pow;
    Pair(int idx,int pow){
        this.idx = idx;
        this.pow = pow;
    }
}
class Solution{
    public int getKth(int lo, int hi, int k){
        // int[] dp = new int[100000];
        // Arrays.fill(dp,-1);
        int[] arr = new int[hi+1];
        for(int i = lo;i<=hi;i++){
            arr[i] = getPower(i);
        }
        
        Pair[] parr = new Pair[hi-lo+1];
        
        int idx = 0;
        for(int i = lo;i<=hi;i++){
            parr[idx++] = new Pair(i,arr[i]);
        }
        
        Arrays.sort(parr,(a,b)->{
            return a.pow - b.pow;
        });
        
        int j = 0;
        while(j<k-1){
            j++;
        }
        return parr[j].idx;
        
    }
    
    public int getPower(int x){
        if(x == 1){
            return  0;
        }
        
        // if(dp[x] != -1){
        //     return dp[x];
        // }
        
        if(x%2 == 0){
            return  1 + getPower(x/2);
        }
        else{
            return  1 + getPower(3*x + 1);
        }
    }
}