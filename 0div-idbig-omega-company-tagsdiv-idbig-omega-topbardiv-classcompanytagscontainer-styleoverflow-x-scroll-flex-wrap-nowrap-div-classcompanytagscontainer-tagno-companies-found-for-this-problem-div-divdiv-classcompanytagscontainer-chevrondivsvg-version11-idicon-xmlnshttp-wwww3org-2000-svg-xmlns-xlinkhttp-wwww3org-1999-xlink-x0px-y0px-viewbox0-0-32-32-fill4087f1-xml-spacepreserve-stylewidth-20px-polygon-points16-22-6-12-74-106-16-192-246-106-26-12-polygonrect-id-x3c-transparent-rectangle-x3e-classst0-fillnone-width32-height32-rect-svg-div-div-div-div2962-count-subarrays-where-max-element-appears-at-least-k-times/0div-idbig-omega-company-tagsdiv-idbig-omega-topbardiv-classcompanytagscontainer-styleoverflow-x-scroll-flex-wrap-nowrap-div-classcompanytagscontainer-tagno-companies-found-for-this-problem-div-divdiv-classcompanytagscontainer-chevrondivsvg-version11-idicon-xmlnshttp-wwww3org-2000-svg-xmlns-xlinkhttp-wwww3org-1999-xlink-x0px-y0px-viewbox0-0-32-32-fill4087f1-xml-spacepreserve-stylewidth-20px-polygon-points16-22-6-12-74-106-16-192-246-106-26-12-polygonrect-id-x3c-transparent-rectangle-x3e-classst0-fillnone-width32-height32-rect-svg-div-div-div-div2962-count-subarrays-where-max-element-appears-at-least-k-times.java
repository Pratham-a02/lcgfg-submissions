class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long total = ((long)n * (n + 1)) / 2;
        int max = 0;
        for (int val : nums) {
            max = Math.max(max, val);
        }
        long cnt = 0;
        int left = 0;
        int[] arr = new int[1];
        for (long right = 0; right < nums.length; right++) {
            if (nums[(int)right] == max) {
                arr[0]++;
            }

            while (arr[0] >= k) {
                if (nums[left] == max) {
                    arr[0]--;
                }
                left++;
            }

            if (arr[0] < k) {
                cnt += (right - left + 1);
            }
        }

        return (total - cnt);
    }
}
