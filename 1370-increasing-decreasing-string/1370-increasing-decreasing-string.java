class Solution{
    public String sortString(String s){
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        String ans = "";
        while(n-->0){
            for(int i = 0;i<26;i++){
                if(freq[i] != 0){
                    ans += (char)('a' + i);
                    freq[i]--;
                }
            }
            
            for(int i = 25;i>=0;i--){
                if(freq[i] != 0){
                    ans += (char)('a' + i);
                    freq[i]--;
                }
            }
        }
        return ans;
    }
}