class Solution{
    public int equalSubstring(String s,String t,int maxCost){
        int max = 0;
        int n = s.length();
        int left = 0;
        int ps = 0;
        
        for(int right = 0;right<n;right++){
            ps += Math.abs(s.charAt(right)-t.charAt(right));
            
            while(left<right && ps>maxCost){
                ps -= Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            if(ps<=maxCost){
                max = Math.max(max,right-left+1);   
            }
        }
        return max;
    }
}