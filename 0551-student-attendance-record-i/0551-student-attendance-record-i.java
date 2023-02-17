class Solution {
    public boolean checkRecord(String s) {
        boolean flag = false;
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'L' && i+1<s.length() && s.charAt(i+1) == 'L' && i+2<s.length() && s.charAt(i+2) == 'L'){
                flag = true;
            }
        }
        
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'A'){
                count++;
            }
        }
        
        if(count<2 && flag == false){
            return true;
        }
        else{
            return false;
        }
    }
}