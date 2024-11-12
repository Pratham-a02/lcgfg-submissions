class Solution{
    public int[] maximumBeauty(int[][] items,int[] queries){
        int[] ans = new int[queries.length];
        Arrays.sort(items,(a,b)->{
           return a[0] - b[0]; 
        });
        
        int[] msf = new int[items.length];
        msf[0] = items[0][1];
        
        for(int i = 1;i<items.length;i++){
            msf[i] = Math.max(items[i][1],msf[i-1]);
        }
        int idx = 0;
        for(int i = 0;i<queries.length;i++){
            int key = queries[i];
            
            int li = 0;
            int ri = items.length-1;
            int res = -1;
            while(li<=ri){
                int mid = li - (li-ri)/2;
                
                if(items[mid][0] <= key){
                    res = mid;
                    li = mid+1;
                }
                else{
                    ri = mid-1;
                }
            }
            ans[idx++] = res != -1?msf[res]:0;
        }
        
        return ans;
    }
}