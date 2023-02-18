class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        int k = 0;
        int idx = 0;
        for(int i = 0;i<s.length();i++){
            int x = startPos[0];
            int y = startPos[1];
            
            int count = 0;
            for(int j = i;j<s.length();j++){
                if(s.charAt(j) == 'R'){
                    y++;
                }
                if(s.charAt(j) == 'D'){
                    x++;
                }
                if(s.charAt(j) == 'L'){
                    y--;
                }
                if(s.charAt(j) == 'U'){
                    x--;
                }
                if(x<0 || y<0 || x>=n || y>=n){
                    break;
                }
                else{
                    count++;
                }
            }
            ans[k++] = count;
        }
        return ans;
    }
}