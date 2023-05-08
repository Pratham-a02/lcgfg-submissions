class Solution{
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        
        for(int i = 0;i<temperatures.length;i++){
            while(st.size()>0 && temperatures[st.peek()]<temperatures[i]){
                int idx = st.pop();
                ans[idx] = i-idx;
            }
            st.push(i);
        }
        return ans;
    }
}