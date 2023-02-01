class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        
        int len = Math.min(len1,len2);
        
        for(int i = len;i>0;i--){
            if(len1%i != 0 || len2%i != 0){
                continue;
            }
            
            if(check(str2.substring(0,i),str2) && check(str2.substring(0,i),str1)){
                return str1.substring(0,i);
            }
        }
        return "";
    }
    
    public boolean check(String pref,String s){
        int n = s.length()/pref.length();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<n;i++){
            sb.append(pref);
        }
        return sb.toString().equals(s);
    }
}