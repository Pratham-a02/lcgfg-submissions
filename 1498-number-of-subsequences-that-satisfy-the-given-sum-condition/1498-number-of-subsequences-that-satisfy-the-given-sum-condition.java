class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = n - 1, res = 0;
        int mod = 1000000007;
        int[] power = new int[n];

        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }


        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res = (res + power[r - l]) % mod; 
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
