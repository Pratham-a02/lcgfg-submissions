class Solution {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        
        boolean flag = true;
        
        int start = 0;
        int max = 0;
        for(int end = 0;end<s.length();end++){
            char ch = s.charAt(end);
            if(freq[ch-'a']>0 && freq[ch-'a']<k){
                String substr = s.substring(start,end);
                max = Math.max(max,longestSubstring(substr,k));
                flag = false;
                start = end+1;
            }
        }
        
        if(flag == true){
            return s.length();
        }
        else{
            return Math.max(max,longestSubstring(s.substring(start),k));
        }
    }
}