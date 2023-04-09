class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        String str = "";
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if((ch>=48 && ch<=57) || ch >= 97 && ch<=122){
                str += ch;
            }
        }
 
        int li = 0;
        int ri = str.length()-1;
        
        while(li<ri){
            if(str.charAt(li) - 'a'  != str.charAt(ri) - 'a'){
                return false;
            }
            li++;
            ri--;
        }
        return true;
    }
}