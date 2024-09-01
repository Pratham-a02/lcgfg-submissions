class Solution{
    public String stringHash(String s,int k){
        String res = "";
        String str = "";
        int n = s.length();
        int parts = n/k;
        
        int idx = 0;
        while(idx<s.length()){
            int i = 0;
            while(idx<s.length() && i<k){
                str += s.charAt(idx);
                i++;
                idx++;
            }
            str += " ";
        }
        
        String[] arr = str.split(" ");
        for(String curr:arr){
            int val = 0;
            for(char c:curr.toCharArray()){
                val += (c-'a');
            }
            val%=26;
            res += (char)(val+'a');
        }
        
        return res;
    }
}