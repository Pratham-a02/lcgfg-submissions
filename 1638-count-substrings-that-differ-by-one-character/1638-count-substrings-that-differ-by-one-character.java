class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        
        for(int i = 0;i<s.length();i++){
            for(int j = 0;j<t.length();j++){
                int d = 0;
                int x = i;
                int y = j;
                
                while(x<s.length() && y<t.length()){
                    if(s.charAt(x) != t.charAt(y)){
                        d++;
                    }
                    if(d == 1){
                        ans++;
                    }
                    if(d>1){
                        break;
                    }
                    x++;
                    y++;
                }
            }
        }
        return ans;
    }
}