class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }
            else{
                char c = convert(ch,(int)s.charAt(i-1));
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public char convert(char ch,int ascii){
        int d = (ch-'0') + ascii;
        char c = (char)d;
        return c;
    }
}