class Solution{
    public int solve(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i == 0 || j == 0) return -1_000_000_000;

        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = Math.max(nums1[i - 1] * nums2[j - 1] + Math.max(0, solve(i - 1, j - 1, nums1, nums2, dp)),Math.max(solve(i - 1, j, nums1, nums2, dp), solve(i, j - 1, nums1, nums2, dp)));

        return dp[i][j];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(n, m, nums1, nums2, dp);
    }
}