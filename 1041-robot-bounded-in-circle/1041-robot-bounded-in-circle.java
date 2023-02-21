class Solution{
    public boolean isRobotBounded(String instructions){
        char currdir = 'N';
        int x = 0;
        int y = 0;
        
        for(int i = 0;i<instructions.length();i++){
            char ch = instructions.charAt(i);
            if(ch == 'G'){
                x += currdir == 'E'?1:0;
                x += currdir == 'W'?-1:0;
                y += currdir == 'N'?1:0;
                y += currdir == 'S'?-1:0;
            }
            else{
                char incoming = instructions.charAt(i);
                if(currdir == 'N'){
                    currdir = incoming == 'L'?'W':'E';
                }
                else if(currdir == 'S'){
                    currdir = incoming == 'L'?'E':'W';
                }
                else if(currdir == 'W'){
                    currdir = incoming == 'L'?'S':'N';
                }
                else{
                    currdir = incoming == 'L'?'N':'S';
                }
            }
        }
        
        if((x == 0 && y == 0) || currdir != 'N'){
            return true;
        }
        return false;
    }
}