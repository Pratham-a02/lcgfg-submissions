class Solution {
    public int fib(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        return fibM(n);
    }
    public static int fibM(int n){
        if(n<=1)
            return n;
        
        int nm1 = fibM(n-1);
        int nm2 = fibM(n-2);
        return nm1+nm2;
    }
}