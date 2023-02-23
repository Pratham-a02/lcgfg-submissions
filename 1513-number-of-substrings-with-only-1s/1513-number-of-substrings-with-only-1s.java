class Solution {
    public int numSub(String s){
        int res = 0;

        int i = 0, j = 0;
        while(j < s.length()){
            if(s.charAt(j) == '1'){
                res = (res + (j - i + 1)) % 1000000007;
                j++;
            } else {
                j++;
                i = j;
            }
        }

        return res;
    }
}