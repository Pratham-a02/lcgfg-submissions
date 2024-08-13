class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, k, target, new ArrayList<>(), ans, nums);
        return ans;
    }

    public void solve(int i, int k, int target, List<Integer> al, List<List<Integer>> ans, int[] nums) {
        if (target == 0 && k == 0) {
            ans.add(new ArrayList<>(al));
            return;
        }
        if (target < 0) return;
        if (target == 0 && k != 0) return;

        for (int idx = i; idx < nums.length; idx++) {
            if (nums[idx] > target) break;

            al.add(nums[idx]);
            solve(idx + 1, k - 1, target - nums[idx], al, ans, nums);
            al.remove(al.size() - 1);
        }
    }
}
