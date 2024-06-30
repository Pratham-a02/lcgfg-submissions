class Solution{
    public boolean judgeSquareSum(int c){
        long ri = (long)(Math.sqrt(c));
        
        long li = 0;
        
        while(li<=ri){
            long val = (li*li + ri*ri);
            if(val == c){
                return true;
            }
            else if(val<c){
                li++;
            }
            else{
                ri--;
            }
        }
        return false;
    }
}