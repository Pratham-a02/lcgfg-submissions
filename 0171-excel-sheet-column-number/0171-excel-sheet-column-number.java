class Solution{
    public int titleToNumber(String columnTitle){
        StringBuilder sb = new StringBuilder(columnTitle);
        
        sb = sb.reverse();
        int ans = 0;
        for(int i = 0;i<sb.length();i++){
            char ch = sb.charAt(i);
            
            ans += (Math.pow(26,i) * ((ch-'A') + 1));
        }
        return ans;
    }
}