class Solution{
    public String largestGoodInteger(String num){
        String ans = "";
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<num.length()-2;i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                int a = num.charAt(i)-'0';
                int b = num.charAt(i+1)-'0';
                int c = num.charAt(i+2)-'0';
                String curr = a + "" + b + "" + c;
                if((a*100 + b*10 + c)> max){
                    ans = curr;
                    max = (a*100 + b*10 + c);
                }
            }
        }
        return ans;
    }
}