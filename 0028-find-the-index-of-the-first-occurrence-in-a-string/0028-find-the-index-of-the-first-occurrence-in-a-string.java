class Solution {
    public int strStr(String txt, String pat) {
       int[] lps = getLPS(pat);
        int i = 0;
        int j = 0;
        
        while(i<txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                
                if(j == pat.length()){
                    return (i-j);
                    // j = lps[j-1];
                }
            }
            else if(j == 0){
                i++;
            }
            else{
                j = lps[j-1];
            }
        }
        return -1;
    }
    
    public static int[] getLPS(String pat){
        int len = 0;
        int i = 1;
        int[] lps = new int[pat.length()];
        // lps[0] = 0;
        while(i<pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                lps[i] = len+1;
                len++;
                i++;
            }
            else if(len == 0){
                lps[i] = 0;
                len = 0;
                i++;
            }
            else{
                len = lps[len-1];
            }
        }
        for(int val:lps){
            System.out.print(val+" ");
        }
        return lps;
    }
}