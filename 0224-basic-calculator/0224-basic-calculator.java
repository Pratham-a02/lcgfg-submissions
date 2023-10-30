class Solution{
    public int calculate(String s){
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        int number = 0;
        int sign = 1;
        int result = 0;
        
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                number = (number*10) + (ch-'0');
            }
            else if(ch == '+'){
                result = result + (sign*number);
                number = 0;
                sign = 1;
            }
            else if(ch == '-'){
                result = result + (sign*number);
                number = 0;
                sign = -1;
            }
            else if(ch == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
                number = 0;
            }
            else if(ch == ')'){
                result += (number*sign);
                number = 0;
                
                int last_sign = st.peek();
                result *= last_sign;
                st.pop();
                int last_no = st.peek();
                result += last_no;
                st.pop();
            }
        }
        result = result + (sign*number);
        return result;
    }
}