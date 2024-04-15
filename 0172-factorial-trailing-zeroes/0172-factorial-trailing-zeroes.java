class Solution {
    public int trailingZeroes(int n) {
        int mul = 5;
        int cnt = 0;
        while((n/mul)>0){
            cnt += (n/mul);
            mul *= 5;
        }
        return cnt;
    }
}