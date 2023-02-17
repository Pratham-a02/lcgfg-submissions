class Solution {
    public int minimumMoves(String s) {
        int count = 0;
        int idx = 0;
        while(idx<s.length()){
            if(s.charAt(idx) == 'X'){
                count++;
                idx+=3;
            }
            else{
                idx++;
            }
        }
        return count;
    }
}