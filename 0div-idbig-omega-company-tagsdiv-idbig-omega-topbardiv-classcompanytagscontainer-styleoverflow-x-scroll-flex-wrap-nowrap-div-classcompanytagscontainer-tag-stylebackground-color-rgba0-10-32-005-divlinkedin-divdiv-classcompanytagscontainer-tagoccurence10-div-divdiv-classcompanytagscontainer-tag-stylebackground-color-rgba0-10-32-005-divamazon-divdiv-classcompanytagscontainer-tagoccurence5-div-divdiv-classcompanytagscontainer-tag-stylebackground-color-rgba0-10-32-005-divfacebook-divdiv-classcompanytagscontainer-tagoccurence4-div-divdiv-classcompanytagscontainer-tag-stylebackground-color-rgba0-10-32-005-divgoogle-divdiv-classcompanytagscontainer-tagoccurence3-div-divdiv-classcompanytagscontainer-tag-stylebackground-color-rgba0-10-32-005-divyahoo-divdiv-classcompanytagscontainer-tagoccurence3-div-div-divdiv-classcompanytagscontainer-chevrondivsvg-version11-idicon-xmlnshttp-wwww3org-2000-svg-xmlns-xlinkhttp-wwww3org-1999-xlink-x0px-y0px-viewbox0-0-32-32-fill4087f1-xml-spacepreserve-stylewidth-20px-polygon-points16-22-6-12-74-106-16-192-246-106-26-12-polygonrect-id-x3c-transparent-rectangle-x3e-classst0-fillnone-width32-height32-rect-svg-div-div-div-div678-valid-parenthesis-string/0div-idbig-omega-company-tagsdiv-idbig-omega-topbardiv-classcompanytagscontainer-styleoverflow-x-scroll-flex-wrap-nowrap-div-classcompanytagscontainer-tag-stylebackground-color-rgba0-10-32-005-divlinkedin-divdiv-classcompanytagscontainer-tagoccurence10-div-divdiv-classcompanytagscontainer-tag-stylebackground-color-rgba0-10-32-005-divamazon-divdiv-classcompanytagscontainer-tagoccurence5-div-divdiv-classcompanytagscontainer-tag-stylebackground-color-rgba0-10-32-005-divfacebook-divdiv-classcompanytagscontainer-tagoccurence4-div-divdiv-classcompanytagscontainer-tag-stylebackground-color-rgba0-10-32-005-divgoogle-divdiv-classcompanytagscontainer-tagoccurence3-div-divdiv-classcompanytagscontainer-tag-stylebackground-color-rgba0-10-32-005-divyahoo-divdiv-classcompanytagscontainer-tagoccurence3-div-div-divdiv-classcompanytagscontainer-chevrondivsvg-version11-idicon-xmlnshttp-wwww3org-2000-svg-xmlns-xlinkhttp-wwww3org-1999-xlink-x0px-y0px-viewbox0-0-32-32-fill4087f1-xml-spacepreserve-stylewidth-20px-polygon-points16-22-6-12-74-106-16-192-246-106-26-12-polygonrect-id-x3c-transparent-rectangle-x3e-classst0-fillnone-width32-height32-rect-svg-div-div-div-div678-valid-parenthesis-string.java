class Solution{
    public boolean checkValidString(String s){
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                st1.push(i);
            }
            else if(ch == ')'){
                if(st1.size()>0){
                    st1.pop();
                }
                else if(st2.size()>0){
                    st2.pop();
                }
                else{
                    return false;
                }
            }
            else if(ch == '*'){
                st2.push(i);
            }
        }
        
        while(st1.size()>0 && st2.size()>0){
            int val = st2.pop();
            if(st1.peek()<val){
                st1.pop();
            }
        }
        
        return st1.isEmpty();
    }
}