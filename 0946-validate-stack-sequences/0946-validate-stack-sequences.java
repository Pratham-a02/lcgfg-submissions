class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        for(int i = 0;i<pushed.length;i++){
            st.push(pushed[i]);
            
            while(st.size()>0 && popped[idx] == st.peek()){
                st.pop();
                idx++;
            }
        }
        
        if(st.size()>0){
            return false;
        }
        else{
            return true;
        }
    }
}