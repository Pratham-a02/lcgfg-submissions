class Solution{
    public boolean winnerOfGame(String colors){
        int ac = 0;
        int bc = 0;
        
        for(int i = 1;i<colors.length()-1;i++){
            if(colors.charAt(i) == 'A'){
                if(colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A'){
                    ac++;
                }
            }
            if(colors.charAt(i) == 'B'){
                if(colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B'){
                    bc++;
                }
            }
        }
        
        if(ac>bc){
            return true;
        }
        else{
            return false;
        }
    }
}