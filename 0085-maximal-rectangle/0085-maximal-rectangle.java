class Solution{
    public int maximalRectangle(char[][] matrix){
        int n = matrix[0].length;
        int[] curr = new int[n];
        int max = Integer.MIN_VALUE;
        for(char[]mat:matrix){
            
            for(int i = 0;i<mat.length;i++){
                if(mat[i] == '1'){
                    curr[i]++;
                }
                else if(mat[i] == '0'){
                    curr[i] = 0;
                }
            }
            
            max = Math.max(max,largestRectangleArea(curr));
        }
        return max;
    }
    
    
    
    public int largestRectangleArea(int[] heights){
        int[] nsor = nsoR(heights);
        int[] nsol = nsoL(heights);
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0;i<heights.length;i++){
            ans = Math.max(ans,(nsor[i]-nsol[i]-1)*heights[i]);
        }
        
        return ans;
    }
    
    public int[] nsoR(int[] heights){
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans,n);
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<n;i++){
            while(st.size()>0 && heights[st.peek()]>heights[i]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        return ans;
    }
    
    public int[] nsoL(int[] heights){
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> st = new Stack<>();
        
        for(int i = n-1;i>=0;i--){
            while(st.size()>0 && heights[st.peek()]>heights[i]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        return ans;
    }
}