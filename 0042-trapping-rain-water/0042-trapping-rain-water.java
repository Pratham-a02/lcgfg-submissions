class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] mfl = new int[height.length];
        int[] mfr = new int[height.length];
        mfl[0] = height[0];
        mfr[n-1] = height[n-1];
        for(int i = 1;i<height.length;i++){
            mfl[i] = Math.max(height[i],mfl[i-1]);
        }
        
        for(int i = n-2;i>=0;i--){
            mfr[i] = Math.max(height[i],mfr[i+1]);
        }
        
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans += Math.min(mfl[i],mfr[i]) - height[i];
        }
        return ans;
    }
}