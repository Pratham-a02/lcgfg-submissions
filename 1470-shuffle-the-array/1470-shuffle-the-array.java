class Solution {
    public int[] shuffle(int[] nums, int n) {
        // List<Integer> al = new ArrayList<>();
        int[] ans = new int[2*n];
        int i = 0;
        int j = n;
        int x= 0;
        while(i<n && j<nums.length){
            ans[x++] = nums[i];
            ans[x++] = nums[j];
            i++;
            j++;
        }
        
        // for(int k = 0;k<ans.length;k++){
        //     ans[k] = al.get(k);
        // }
        return ans;
    }
}