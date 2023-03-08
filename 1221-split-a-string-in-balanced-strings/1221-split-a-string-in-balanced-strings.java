class Solution {
    public int balancedStringSplit(String s) {
      int count = 0;
        int countR = 0;
        int countL = 0;
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'R'){
                countR++;
            }
            else{
                countL++;
            }
            
            if(countR == countL){
                count++;
                countR = 0;
                countL = 0;
            }
        }
        
        if(count == 0 || countR != 0 || countL != 0){
            return -1;
        }
        else{
            return count;
        }
    }
}