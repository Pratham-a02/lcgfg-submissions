class Solution {
    public String removeDigit(String s, char digit) {
        String ans = "";
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == digit){
                String curr = s.substring(0,i) + s.substring(i+1);
                if(ans == ""){
                    ans = curr;
                }
                else{
                    if(curr.compareTo(ans)>0){
                        ans = curr;
                    }
                }
            }
        }
        
        return ans;
    }
}