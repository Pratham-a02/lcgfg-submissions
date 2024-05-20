class Solution{
    public int sumOddLengthSubarrays(int[] arr){
        int ans = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            int start = (n-i);
            int end = (i+1);
            int totalPossible = (start*end);
            int oddSub = totalPossible/2;
            if(totalPossible%2 != 0){
                oddSub++;
            }
            
            ans += (oddSub*arr[i]);
        }
        return ans;
    }
}