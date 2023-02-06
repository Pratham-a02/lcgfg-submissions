class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        Arrays.fill(left,Integer.MAX_VALUE);
        Arrays.fill(right,Integer.MAX_VALUE);
        int counter = Integer.MAX_VALUE;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == c){
                left[i] = 0;
                counter = 0;
                counter++;
                continue;
            }
            left[i] = counter;
            if(counter!=Integer.MAX_VALUE){
                counter++;
            }
        }
        
        counter = Integer.MAX_VALUE;
        for(int i = s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == c){
                right[i] = 0;
                counter = 0;
                counter++;
                continue;
            }
            right[i] = counter;
            if(counter!=Integer.MAX_VALUE){
                counter++;
            }
        }
        
        int[] ans = new int[s.length()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = Math.min(left[i],right[i]);
        }
        return ans;
    }
}