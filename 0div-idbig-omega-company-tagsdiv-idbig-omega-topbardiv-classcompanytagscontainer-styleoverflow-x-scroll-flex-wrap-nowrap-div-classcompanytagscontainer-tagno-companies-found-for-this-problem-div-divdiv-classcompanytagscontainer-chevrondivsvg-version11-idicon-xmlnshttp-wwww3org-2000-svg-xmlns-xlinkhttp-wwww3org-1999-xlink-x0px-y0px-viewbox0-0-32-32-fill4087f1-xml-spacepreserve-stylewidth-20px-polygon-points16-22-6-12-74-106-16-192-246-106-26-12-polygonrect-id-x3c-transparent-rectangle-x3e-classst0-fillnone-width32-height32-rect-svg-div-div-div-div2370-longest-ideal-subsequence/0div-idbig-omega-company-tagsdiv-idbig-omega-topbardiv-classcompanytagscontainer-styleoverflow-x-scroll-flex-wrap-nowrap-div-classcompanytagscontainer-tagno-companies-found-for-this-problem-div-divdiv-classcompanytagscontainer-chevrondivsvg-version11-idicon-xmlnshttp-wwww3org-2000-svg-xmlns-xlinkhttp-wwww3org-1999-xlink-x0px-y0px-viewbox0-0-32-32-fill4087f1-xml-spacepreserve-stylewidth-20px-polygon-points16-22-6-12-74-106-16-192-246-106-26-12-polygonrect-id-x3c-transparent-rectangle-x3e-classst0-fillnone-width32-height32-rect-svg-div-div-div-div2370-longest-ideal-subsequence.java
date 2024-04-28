class Solution{
    public int longestIdealString(String s, int k){
        int[] farr = new int[26];
        
        int ans = 0;
        
        for(int i = 0;i<s.length();i++){
            int curr = s.charAt(i) - 'a';
            
            int left = Math.max(0,curr-k);
            int right = Math.min(25,curr+k);
            int longest = 0;
            for(int j = left;j<=right;j++){
                longest = Math.max(longest,farr[j]);
            }
            
            farr[curr] = Math.max(farr[curr],longest+1);
            ans = Math.max(ans,farr[curr]);
        }
        return ans;
    }
}