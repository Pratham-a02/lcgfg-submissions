class Solution{
    public List<String> summaryRanges(int[] nums){
        int i = 0;
        int j = 1;
        List<String> ans = new ArrayList<>();
        
        while(i<nums.length && j<nums.length){
            while(j<nums.length && nums[j] == nums[j-1]+1){
                j++;
            }
            j--;
            if(i == j){
                ans.add(nums[i]+"");
            }
            else{
                String curr = nums[i] + "->" + nums[j];
                ans.add(curr);
            }
            i = j+1;
            j = i+1;
        }
        if(i < nums.length){
            ans.add(nums[i]+"");
        }
        return ans;
    }
}