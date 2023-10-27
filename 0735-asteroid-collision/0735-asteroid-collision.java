class Solution{
    public int[] asteroidCollision(int[] asteroids){
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        
        for(int val:asteroids){
            
            while(st.size()>0 && val<0 && st.peek()>0){
                int sum = val + st.peek();
                
                if(sum<0){
                    st.pop();
                }
                else if(sum>0){
                    val = 0;
                }
                else{
                    st.pop();
                    val = 0;
                }
            }
            
            if(val != 0){
                st.push(val);
            }
        }
        
        int[] ans = new int[st.size()];
        int idx = ans.length-1;
        while(st.size()>0){
            int val = st.pop();
            ans[idx] = val;
            idx--;
        }
        return ans;
    }
}