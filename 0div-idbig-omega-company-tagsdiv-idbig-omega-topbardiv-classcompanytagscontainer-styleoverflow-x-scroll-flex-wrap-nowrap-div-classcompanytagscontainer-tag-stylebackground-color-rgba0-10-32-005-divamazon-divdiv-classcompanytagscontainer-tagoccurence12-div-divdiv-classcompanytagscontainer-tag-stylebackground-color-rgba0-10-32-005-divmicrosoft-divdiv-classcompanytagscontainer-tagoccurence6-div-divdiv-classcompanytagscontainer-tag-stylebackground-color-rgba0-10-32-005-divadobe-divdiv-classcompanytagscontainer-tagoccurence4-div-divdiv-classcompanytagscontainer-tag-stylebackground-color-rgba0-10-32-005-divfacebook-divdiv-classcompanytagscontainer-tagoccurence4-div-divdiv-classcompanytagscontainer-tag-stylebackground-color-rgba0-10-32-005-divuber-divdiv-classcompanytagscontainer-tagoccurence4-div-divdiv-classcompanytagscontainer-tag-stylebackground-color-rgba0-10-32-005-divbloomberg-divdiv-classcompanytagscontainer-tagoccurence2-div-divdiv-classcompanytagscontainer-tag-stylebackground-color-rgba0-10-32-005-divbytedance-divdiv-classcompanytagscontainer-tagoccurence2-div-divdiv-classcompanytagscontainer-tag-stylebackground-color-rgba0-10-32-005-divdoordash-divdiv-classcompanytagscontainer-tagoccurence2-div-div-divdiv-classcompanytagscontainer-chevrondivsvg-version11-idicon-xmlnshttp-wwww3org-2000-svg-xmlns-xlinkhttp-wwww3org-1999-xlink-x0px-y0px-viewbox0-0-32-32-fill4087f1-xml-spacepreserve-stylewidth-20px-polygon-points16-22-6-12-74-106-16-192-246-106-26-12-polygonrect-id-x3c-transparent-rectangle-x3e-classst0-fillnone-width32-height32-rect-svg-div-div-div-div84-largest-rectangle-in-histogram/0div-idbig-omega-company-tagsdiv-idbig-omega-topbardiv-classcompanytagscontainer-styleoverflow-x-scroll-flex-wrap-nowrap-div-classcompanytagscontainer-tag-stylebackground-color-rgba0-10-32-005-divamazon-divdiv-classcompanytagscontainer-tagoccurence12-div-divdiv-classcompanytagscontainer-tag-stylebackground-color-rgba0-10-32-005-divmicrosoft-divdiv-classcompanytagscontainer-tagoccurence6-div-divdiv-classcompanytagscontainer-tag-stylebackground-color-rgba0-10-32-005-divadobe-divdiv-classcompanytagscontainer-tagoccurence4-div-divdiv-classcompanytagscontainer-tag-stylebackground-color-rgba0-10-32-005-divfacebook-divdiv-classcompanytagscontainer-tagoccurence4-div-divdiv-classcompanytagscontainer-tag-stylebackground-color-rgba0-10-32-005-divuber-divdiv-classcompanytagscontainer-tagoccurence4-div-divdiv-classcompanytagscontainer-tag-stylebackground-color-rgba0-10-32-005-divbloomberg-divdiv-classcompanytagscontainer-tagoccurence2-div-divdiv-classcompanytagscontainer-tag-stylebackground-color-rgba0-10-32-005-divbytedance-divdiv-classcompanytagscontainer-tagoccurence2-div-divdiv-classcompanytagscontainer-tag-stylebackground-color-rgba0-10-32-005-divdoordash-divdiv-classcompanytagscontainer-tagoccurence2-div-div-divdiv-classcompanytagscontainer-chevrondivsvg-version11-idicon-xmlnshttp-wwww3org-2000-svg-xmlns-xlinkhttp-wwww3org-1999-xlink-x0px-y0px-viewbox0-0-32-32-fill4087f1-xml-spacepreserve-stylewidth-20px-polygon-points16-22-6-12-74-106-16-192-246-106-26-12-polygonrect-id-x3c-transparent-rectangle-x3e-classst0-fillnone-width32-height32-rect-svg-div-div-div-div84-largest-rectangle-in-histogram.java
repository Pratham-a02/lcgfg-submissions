class Solution{
    public int largestRectangleArea(int[] heights) {
        int[] nsl = nsol(heights);
        int[] nsr = nsor(heights);
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i<heights.length;i++){
            max = Math.max(max,(nsr[i]-nsl[i]-1)*heights[i]);
        }
        return max;
    }
    
    public int[] nsol(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans,-1);
        for(int i = arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[i] < arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        return ans;
    }
    
    public int[] nsor(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans,arr.length);
        for(int i = 0;i<arr.length;i++){
            while(st.size()>0 && arr[i] < arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        return ans;
    }
}