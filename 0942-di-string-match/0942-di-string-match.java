class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n+1];
        int hi = n;
        int lo = 0;
        int idx = 0;
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == 'D'){
                ans[idx++] = hi--; 
            }
            else{
                ans[idx++] = lo++;
            }
        }
        ans[idx] = hi;
        return ans;
    }
}