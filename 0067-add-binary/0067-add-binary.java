class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int i = 0;
        int carry = 0;
        while(i<a.length() || i<b.length() || carry!=0){
            int x = 0;
            if(i<a.length() && a.charAt(a.length() - 1 -i) == '1'){
                x = 1;
            }
            int y = 0;
            if(i<b.length() && b.charAt(b.length() - 1 -i) == '1'){
                y = 1;
            }
            
            res = (x+y+carry)%2 + res;
            carry = (x+y+carry)/2;
            i++;
        }
        
        return res;
    }
}