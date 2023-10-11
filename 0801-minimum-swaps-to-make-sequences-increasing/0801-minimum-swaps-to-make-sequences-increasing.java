class Solution{
    public int minSwap(int[] nums1,int[] nums2){
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        al1.add(-1);
        al2.add(-1);
        for(int val:nums1){
            al1.add(val);
        }
        for(int val:nums2){
            al2.add(val);
        }
        int[][] dp = new int[nums1.length+1][2];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return solve(1,al1,al2,0,dp);
    }
    
    public int solve(int idx,List<Integer> nums1,List<Integer> nums2,int swapped,int[][] dp){
        if(idx >= nums1.size()){
            return 0;
        }
        
        if(dp[idx][swapped] != -1){
            return dp[idx][swapped];
        }
        
        int ans = Integer.MAX_VALUE;
        
        int prev1 = nums1.get(idx-1);
        int prev2 = nums2.get(idx-1);
        if(swapped == 1){
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }
        //noswap
        if(nums1.get(idx)>prev1 && nums2.get(idx)>prev2){
            ans = solve(idx+1,nums1,nums2,0,dp);
        }
        
        //swap case
        if(nums1.get(idx)>prev2 && nums2.get(idx)>prev1){
            ans = Math.min(ans,1 + solve(idx+1,nums1,nums2,1,dp));
        }
        
        return dp[idx][swapped] = ans;
    }
}