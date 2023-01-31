class Solution {
    public String shortestPalindrome(String s) {
        String s1 = s + "#" + new StringBuilder(s).reverse().toString();
        
        int[] lps = new int[s1.length()];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while(i<s1.length()){
            if(s1.charAt(i) == s1.charAt(len)){
                lps[i] = len+1;
                len++;
                i++;
            }
            else if(len == 0){
                len = 0;
                lps[i] = 0;
                i++;
            }
            else{
                len = lps[len-1];
            }
        }
        
        int ppl = lps[lps.length-1];
        String ros = s.substring(ppl);
        return new StringBuilder(ros).reverse().toString() + s;
    }
}