class Solution{
    public int[] getAverages(int[] nums, int k){
        if(k == 0) return nums;
       // if(k > nums.length) return new int[]{-1};
        
        long[] ans = new long[nums.length];
        
        int idx = 0;
        while(idx < nums.length){
            if(idx < k || idx + k >= nums.length){
                ans[idx] = -1;
            }
            idx++;
        }
        
        
        long[] ps = new long[nums.length];
        
        long currsum = 0;
        for(int i = 0;i<ps.length;i++){
            currsum += nums[i];
            ps[i] = currsum;
        }
        
        for(int i = k;i<nums.length-k;i++){
            if((i - k - 1) >= 0){
                ans[i] = (ps[k+i] - ps[i-k-1])/((i+k) - (i-k) + 1);
            }
            else{
                ans[i] = (ps[k+i])/((i+k) - (i-k) + 1);
            }
        }
        int[] fAns = new int[ans.length];
        for(int i = 0;i<ans.length;i++){
            fAns[i] = (int)(ans[i]);
        }
        return fAns;
    }
}

