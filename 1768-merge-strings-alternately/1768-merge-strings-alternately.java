class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        boolean flag = true;
        
        int i = 0;
        int j = 0;
        while(i<word1.length() && j<word2.length()){
            if(flag){
                res+=word1.charAt(i);
                i++;
                flag = false;
            }
            else{
                res += word2.charAt(j);
                j++;
                flag = true;
            }
        }
        while(i<word1.length()){
            res += word1.charAt(i);
            i++;
        }
        
        while(j<word2.length()){
            res += word2.charAt(j);
            j++;
        }
        return res;
    }
}