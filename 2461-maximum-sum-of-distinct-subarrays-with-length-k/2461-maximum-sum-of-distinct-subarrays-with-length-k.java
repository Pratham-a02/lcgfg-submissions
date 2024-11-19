class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long ps = 0; // Current prefix sum
        int left = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            ps += nums[right];
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);

            // Shrink window if duplicate found or size exceeds k
            while (hm.get(nums[right]) > 1 || (right - left + 1) > k) {
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0) {
                    hm.remove(nums[left]);
                }
                ps -= nums[left];
                left++;
            }

            // Update maximum sum if window size is exactly k
            if ((right - left + 1) == k) {
                ans = Math.max(ans, ps);
            }
        }
        return ans;
    }
}
