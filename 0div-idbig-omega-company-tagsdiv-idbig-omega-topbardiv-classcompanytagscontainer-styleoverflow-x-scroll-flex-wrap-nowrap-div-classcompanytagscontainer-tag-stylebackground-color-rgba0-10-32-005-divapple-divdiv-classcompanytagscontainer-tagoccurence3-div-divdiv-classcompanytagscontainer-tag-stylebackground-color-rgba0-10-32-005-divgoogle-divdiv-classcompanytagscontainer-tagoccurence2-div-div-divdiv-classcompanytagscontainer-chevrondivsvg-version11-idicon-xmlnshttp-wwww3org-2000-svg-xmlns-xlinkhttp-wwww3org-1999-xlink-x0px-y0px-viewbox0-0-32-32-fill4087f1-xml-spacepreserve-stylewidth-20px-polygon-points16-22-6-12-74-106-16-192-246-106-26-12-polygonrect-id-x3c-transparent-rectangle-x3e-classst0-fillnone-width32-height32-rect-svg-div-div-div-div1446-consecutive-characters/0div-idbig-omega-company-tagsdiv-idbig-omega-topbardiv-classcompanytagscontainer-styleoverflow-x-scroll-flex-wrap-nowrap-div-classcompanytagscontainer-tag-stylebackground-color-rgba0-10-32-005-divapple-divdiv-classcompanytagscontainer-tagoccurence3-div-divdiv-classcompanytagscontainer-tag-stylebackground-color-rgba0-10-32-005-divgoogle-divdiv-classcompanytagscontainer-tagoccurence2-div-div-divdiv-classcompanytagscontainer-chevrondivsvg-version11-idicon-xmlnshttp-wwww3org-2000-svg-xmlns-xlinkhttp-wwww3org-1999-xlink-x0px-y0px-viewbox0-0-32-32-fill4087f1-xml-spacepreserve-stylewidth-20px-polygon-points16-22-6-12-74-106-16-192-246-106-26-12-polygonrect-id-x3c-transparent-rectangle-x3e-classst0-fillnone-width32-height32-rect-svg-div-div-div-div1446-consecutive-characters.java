class Solution{
    public int maxPower(String s){
        int max = 1;
        int left = 0;
        int right = 0;
        while(right<s.length()){
            if(right+1<s.length() && s.charAt(right) == s.charAt(right+1)){
                right++;
            }
            else{
                max = Math.max(max,right-left+1);
                left = right+1;
                right++;
            }
        }
        return max;
    }
}