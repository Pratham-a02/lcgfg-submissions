class Solution{
    public boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'c'){
                if(st.isEmpty()){
                    return false;
                }
                else if(st.peek() != 'b'){
                    return false;
                }
                else{
                    if(st.isEmpty()){
                        return false;
                    }
                    char ch1 = st.pop();
                    if(st.isEmpty()){
                        return false;
                    }
                    char ch2 = st.pop();
                    if(ch1 != 'b' || ch2 != 'a'){
                        return false;
                    }
                }
            }
            else{
                st.push(ch);
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