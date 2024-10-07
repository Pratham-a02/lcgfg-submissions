class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(st.size()>0){
                if(s.charAt(i) == 'B' && st.peek() == 'A'){
                    st.pop();
                }
                else if(s.charAt(i) == 'D' && st.peek() == 'C'){
                    st.pop();
                }
                else{
                    st.push(s.charAt(i));
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.size();
    }
}