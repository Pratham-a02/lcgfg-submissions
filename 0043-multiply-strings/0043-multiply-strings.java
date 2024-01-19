class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length()+num2.length()];
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        if(num1.equals("1")){
            return num2;
        }
        if(num2.equals("1")){
            return num1;
        }
        
        for(int i = num1.length()-1;i>=0;i--){
            for(int j = num2.length()-1;j>=0;j--){
                int prod = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                prod += res[i+j+1];
                
                res[i+j+1] = prod%10;
                res[i+j] += prod/10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int r:res){
            if(sb.length() == 0 && r == 0){
                continue;
            }
            sb.append(r);
        }
        return sb.toString();
    }
}