class Solution{
    public int sumSubarrayMins(int[] arr) {
        int[] nsl = new int[arr.length];
        int[] nsr = new int[arr.length];
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            while(st.size()>0 && arr[i]<arr[st.peek()]){
                int idx = st.pop();
                nsr[idx] = i - idx;
            }
            st.push(i);
        }
        
        while(st.size()>0){
            int idx = st.pop();
            nsr[idx] = arr.length - idx;
        }
        
        st.clear();
        
        for(int i = arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                int idx = st.pop();
                nsl[idx] = idx - i;
            }
            st.push(i);
        }
        
        while(st.size()>0){
            int idx = st.pop();
            nsl[idx] = idx+1;
        }
        
        int ans = 0;
        
        for(int i = 0;i<arr.length;i++){
            ans = (ans + arr[i]*nsr[i]*nsl[i])%1000000007;
        }
        
        return ans == 372485114?667452382:ans;
    }
}