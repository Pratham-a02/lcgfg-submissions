class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> al = new ArrayList<>();
        int i = 0;
        int j = n;
        while(i<n && j<nums.length){
            al.add(nums[i]);
            al.add(nums[j]);
            i++;
            j++;
        }
        int[] ans = new int[al.size()];
        for(int k = 0;k<ans.length;k++){
            ans[k] = al.get(k);
        }
        return ans;
    }
}