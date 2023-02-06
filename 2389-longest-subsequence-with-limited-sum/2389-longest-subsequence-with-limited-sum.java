class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        // Arrays.sort(queries);
        int[] ans = new int[queries.length];
        int j = 0;
        while(j<queries.length){
            int sum = queries[j];
            int ps = 0;
            int left = 0;
            int right = 0;
            int max = 0;
            while(right<nums.length){
                ps+=nums[right];
                if(ps<=sum){
                    max = Math.max(max,right-left+1);
                    right++;
                }
                if(right == nums.length){
                    if(ps<=sum)
                        ans[j]=max;
                }
                if(ps>sum){
                    ans[j] = max;
                    break;
                }
            }
            j++;
        }
        return ans;
    }
}