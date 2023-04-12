class Solution {
    public String reorganizeString(String s) {
        int[] farr = new int[26];
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            farr[ch-'a']++;
        }
        int max = Integer.MIN_VALUE;
        char ch = ' ';
        for(int i = 0;i<farr.length;i++){
            if(farr[i] > max){
                max = farr[i];
                ch = (char)(i+'a');
            }
        }
        
        if(max>(s.length()+1)/2){
          return "";  
        }
        
        char[] arr = new char[s.length()];
        int idx = 0;
        while(max>0){
            arr[idx] = ch;
            idx+=2;
            max--;
        }
        
        farr[ch-'a'] = 0;
        
        for(int i = 0;i<farr.length;i++){
            while(farr[i]>0){
                idx = (idx >= s.length()) ? 1 : idx;
                
                arr[idx] = (char)(i+'a');
                idx+=2;
                farr[i]--;
            }
        }
        
        String res = "";
        for(int i = 0;i<arr.length;i++){
            res += arr[i];
        }
        return res;
    }
}