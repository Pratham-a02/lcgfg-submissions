class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length -1 ;
        
        while(left<=right){
            if(height[left] <height[right]){
                ans = Math.max(ans,(right-left)*height[left]);
                left++;
            }
            else if(height[left] > height[right]){
                ans = Math.max(ans,(right-left)*height[right]);
                right--;
            }
            else if(height[left] == height[right]){
                ans = Math.max(ans,(right-left)*height[left]);
                left++;
            }
        }
        return ans;
    }
}