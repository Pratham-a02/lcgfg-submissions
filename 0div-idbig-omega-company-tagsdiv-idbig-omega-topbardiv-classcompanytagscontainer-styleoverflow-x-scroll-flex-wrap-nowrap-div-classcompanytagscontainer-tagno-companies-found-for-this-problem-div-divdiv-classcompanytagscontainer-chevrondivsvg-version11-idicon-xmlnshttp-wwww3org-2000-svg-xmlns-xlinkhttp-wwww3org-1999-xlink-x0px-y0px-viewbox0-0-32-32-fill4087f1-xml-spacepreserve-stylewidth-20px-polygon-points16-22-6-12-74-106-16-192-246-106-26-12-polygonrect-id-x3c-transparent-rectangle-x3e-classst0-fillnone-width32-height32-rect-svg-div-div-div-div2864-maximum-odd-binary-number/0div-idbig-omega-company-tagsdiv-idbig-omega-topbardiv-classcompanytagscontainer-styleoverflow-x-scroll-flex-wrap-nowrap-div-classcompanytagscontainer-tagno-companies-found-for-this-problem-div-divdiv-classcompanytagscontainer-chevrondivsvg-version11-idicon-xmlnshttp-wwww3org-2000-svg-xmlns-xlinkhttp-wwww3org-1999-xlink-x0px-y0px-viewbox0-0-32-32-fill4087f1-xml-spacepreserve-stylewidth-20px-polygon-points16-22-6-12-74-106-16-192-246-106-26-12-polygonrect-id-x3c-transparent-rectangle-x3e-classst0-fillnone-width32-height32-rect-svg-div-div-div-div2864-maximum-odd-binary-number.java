class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0;i<s.length();i++){
            sb.append("0");
        }
        
        int i = 0;
        for(char ch:s.toCharArray()){
            if(ch == '1'){
                if(sb.charAt(n-1) == '1'){
                    sb.setCharAt(i,'1');
                    i++;
                }
                else{
                    sb.setCharAt(n-1,'1');
                }
            }
            
        }
        return sb.toString();
    }
}