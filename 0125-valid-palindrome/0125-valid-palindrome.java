class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for(int i = 0; i<s.length(); i++){
            int ch = s.charAt(i);
            if (ch >=97 && ch<=122 || ch>=48 && ch<=57) str+=s.charAt(i);
        }
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}