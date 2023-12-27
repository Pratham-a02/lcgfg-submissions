class Solution{
    public int maxArea(int[] height){
        int n = height.length;
        int i = 0;
        int j = n-1;
        int ans = Integer.MIN_VALUE;
        
        while(i<j){
            ans = Math.max(ans,Math.min(height[i],height[j])*(j-i));   
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}