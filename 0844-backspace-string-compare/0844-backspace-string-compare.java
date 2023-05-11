class Solution{
    public boolean backspaceCompare(String s,String t){
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '#'){
                if(!st1.isEmpty()){
                    st1.pop();
                }
            }
            else{
                st1.push(ch);
            }
        }
        
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            
            if(ch == '#'){
                if(!st2.isEmpty()){
                    st2.pop();
                }
            }
            else{
                st2.push(ch);
            }
        }
        
        String S = "";
        String T = "";
        
        while(st1.size()>0){
            char ch = st1.pop();
            S += ch;
        }
        
        while(st2.size()>0){
            char ch = st2.pop();
            T += ch;
        }
        
        return (S.equals(T));
    }
}