class Solution{
    public int totalSteps(int[] nums){
        int n = nums.length;
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        st.push(new Pair<>(nums[n-1],0));
        int ans = 0;
        for(int i = n-2;i>=0;i--){
            int count = 0;
            while(st.size()>0 && st.peek().getKey()<nums[i]){
                count = Math.max(count+1,st.peek().getValue());
                st.pop();
            }
            ans = Math.max(ans,count);
            st.push(new Pair<>(nums[i],count));
        }
        
        return ans;
    }
}