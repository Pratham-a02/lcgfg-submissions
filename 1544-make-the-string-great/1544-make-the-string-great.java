class Solution{
    public String makeGood(String s){
       Stack<Character> st = new Stack<>();
       
       for(int i = 0;i<s.length();i++){
          char ch = s.charAt(i);
           if(st.isEmpty()){
               st.push(ch);
           }
          else if((char)(st.peek()-32) == ch){
              st.pop();
          }
          else if((char)(st.peek()+32) == ch){
              st.pop();
          }
          else{
              st.push(ch);
          }
       }
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}