class Solution{
    public String removeOuterParentheses(String s){
        String ans = "";
        int count = 0;
        boolean flag = false;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '(') count++;
            else if(ch == ')') count--;
            
            if(count>1){
                ans += ch;
            }
            else if(count == 1){
                if(flag == true){
                    ans += ch;
                }
                else{
                    flag = true;
                }
            }
            
            if(count == 0){
                flag = false;
            }
        }
        return ans;
    }
}