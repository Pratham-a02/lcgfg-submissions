class Solution {
    public String reformatNumber(String number) {
        number = number.replaceAll("\\s", "");
        String str = "";
        for(int i = 0;i<number.length();i++){
            if(number.charAt(i) != '-'){
                str += number.charAt(i);
            }
        }
        String res = "";
        while(str.length()>4){
            res += str.substring(0,3);
            res += "-";
            str = str.substring(3);
        }
        
        while(str.length() == 4){
            res += str.substring(0,2);
            res += "-";
            str = str.substring(2);
        }
        
        if(str.length() == 3 || str.length() == 2){
            res += str.substring(0,str.length());
        }
        
            res = res.replaceAll("\\s", "");
            return res;
        
    }
}