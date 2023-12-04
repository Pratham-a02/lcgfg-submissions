class Solution{
    public String largestGoodInteger(String num){
        String ans = "";
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<num.length()-2;i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                if(Integer.parseInt(num.substring(i,i+3))>max){
                    max = Integer.parseInt(num.substring(i,i+3));
                    ans = num.substring(i,i+3);
                }
            }
        }
        return ans;
    }
}