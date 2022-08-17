class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return "" + nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        String res = nums[0] + "/(";
        for (int i = 1; i < nums.length - 1; i++) res += nums[i] + "/";
        return res + nums[nums.length - 1] + ")";
    }
    }