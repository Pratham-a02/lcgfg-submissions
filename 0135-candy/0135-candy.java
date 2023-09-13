class Solution{
    public int candy(int[] ratings){
        int n = ratings.length;
        int[] rl = new int[ratings.length];
        int[] rr = new int[ratings.length];
        
        rl[0] = 1;
        rr[n-1] = 1;
        for(int i = 1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                rl[i] = rl[i-1]+1;
            }
            else{
                rl[i] = 1;
            }
        }
        
        for(int i = n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                rr[i] = rr[i+1]+1;
            }
            else{
                rr[i] = 1;
            }
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans += Math.max(rl[i],rr[i]);
        }
        
        return ans;
    }
}