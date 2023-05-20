class Solution{
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        if(n == 2){
            return "11";
        }
        
        String curr = countAndSay(n-1);
        
        String res = "";
        int count = 1;
        
        for(int i = 1;i<curr.length();i++){
            if(curr.charAt(i) == curr.charAt(i-1)){
                count++;
            }
            else{
                res += count;
                res += curr.charAt(i-1);
                count = 1;
            }
            
            if(i == curr.length()-1){
                res += count;
                res += curr.charAt(i);
            }
        }
        return res;
    }
}