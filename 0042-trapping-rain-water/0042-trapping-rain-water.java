class Solution {
    public int trap(int[] height) {
        int[] mfl = new int[height.length];
        int[] mfr = new int[height.length];
        
        for(int i = 0;i<height.length;i++){
            if(i == 0){
                mfl[i] = height[i];
            }
            else{
                mfl[i] = Math.max(height[i],mfl[i-1]);
            }
        }
        
        for(int i = height.length-1;i>=0;i--){
            if(i == height.length-1){
                mfr[i] = height[i];
            }
            else{
                mfr[i] = Math.max(height[i],mfr[i+1]);
            }
        }
        
        int ans = 0;
        for(int i = 0;i<height.length;i++){
            ans += Math.min(mfr[i],mfl[i]) - height[i];
        }
        
        return ans;
    }
}