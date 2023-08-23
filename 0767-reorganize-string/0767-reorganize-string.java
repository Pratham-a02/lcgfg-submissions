class Solution {
    public String reorganizeString(String s) {
        int max = Integer.MIN_VALUE;
        
        int[] farr = new int[26];
        for(char ch:s.toCharArray()){
            farr[ch-'a']++;
        }
        
        char ch = ' ';
        for(int i = 0;i<farr.length;i++){
            if(farr[i] > max){
                max = farr[i];
                ch = (char)(i + 'a');
            }
        }
        
        if(max > (s.length()+1)/2) return "";
        
        int idx = 0;
        char[] ans = new char[s.length()];
        while(max>0){
            ans[idx] = ch;
            idx+=2;
            max--;
        }
        
        farr[ch-'a'] = 0;
        
        for(int i = 0;i<farr.length;i++){
            while(farr[i] > 0){
                idx = idx>=s.length()?1:idx;
                ans[idx] = (char)(i+'a');
                farr[i]--;
                idx+=2;
            }
        }
        String res = "";
        for(int i = 0;i<ans.length;i++){
            res += ans[i];
        }
        return res;
    }
}