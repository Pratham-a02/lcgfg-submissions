class Solution {
    public int bulbSwitch(int n) {
        if(n<=1){
            return n;
        }
        
        int count = 0;
        for(int i = 1;i*i<=n;i++){
            count++;
        }
        return count;
    }
}