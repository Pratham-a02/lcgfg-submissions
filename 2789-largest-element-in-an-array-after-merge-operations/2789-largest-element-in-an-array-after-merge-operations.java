class Solution{
    public long maxArrayValue(int[] nums){
        int n = nums.length;
        Stack<Long> st = new Stack<>();
        long ans = nums[n-1];
        st.push((long)(nums[nums.length-1]));
        
        for(int i = n-2;i>=0;i--){
            long curr = nums[i];
            long poppedEle = 0;
            if(!st.isEmpty()){
                poppedEle = st.pop();
                poppedEle = (poppedEle>=curr)?poppedEle:0;
            }
            st.push(poppedEle+curr);
            ans = Math.max(ans,Math.max(curr,st.isEmpty()?0:st.peek()));
        }
        return ans;
    }
}