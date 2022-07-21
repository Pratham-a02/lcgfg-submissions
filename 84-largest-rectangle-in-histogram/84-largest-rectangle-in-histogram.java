class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsor = nsr1(heights);
        int[] nsol = nsl1(heights);
        int max = 0;
        for(int i = 0;i<heights.length;i++){
            int width = nsor[i] - nsol[i] - 1;
            int area = heights[i]*width;
            max = Math.max(max,area);
        }
        return max;
    }
    public int[] nsr1(int[] arr){
        int n = arr.length;
        int[] nsr = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(st.size()!=0 && arr[st.peek()]>arr[i]){
                int idx = st.pop();
                nsr[idx] = i;
            }
            st.push(i);
        }
        while(st.size()!=0){
            int idx = st.pop();
            nsr[idx] = n;
        }
        return nsr;
    }
    public int[] nsl1(int[] arr){
        int n = arr.length;
        int[] nsl = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(st.size()!=0 && arr[st.peek()]>arr[i]){
                int idx = st.pop();
                nsl[idx] = i;
            }
            st.push(i);
        }
        while(st.size()!=0){
            int idx = st.pop();
            nsl[idx] = -1;
        }
        return nsl;
    }
}