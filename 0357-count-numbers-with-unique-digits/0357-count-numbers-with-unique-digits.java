class Solution{
    public int countNumbersWithUniqueDigits(int n){
        if(n == 0) return 1;
        
        int ans = 10;
        int start = 9;
        int curr = 9;
        
        while(n-->1 && start>0){
            curr = curr*(start--);
            ans += curr;
        }
        return ans;
    }
}