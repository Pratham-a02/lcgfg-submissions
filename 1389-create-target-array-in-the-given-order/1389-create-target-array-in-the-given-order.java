class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> al = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            al.add(index[i],nums[i]);
        }
        int[] ans = new int[al.size()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}