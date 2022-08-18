class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return maxLines(0,0,nums1,nums2,dp);
    }
    public int maxLines(int i, int j, int[] nums1, int[] nums2,int[][] dp){
        if(i>= nums1.length || j>= nums2.length){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int count = 0;
        if(nums1[i] == nums2[j]){
            count += 1 + maxLines(i+1,j+1,nums1,nums2,dp);
        }
        else{
            count += Math.max(maxLines(i+1,j+1,nums1,nums2,dp),Math.max(maxLines(i,j+1,nums1,nums2,dp),maxLines(i+1,j,nums1,nums2,dp))); 
        }
        return dp[i][j] = count;
    }
}