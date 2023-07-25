class Solution{
    public List<Integer> findAnagrams(String s,String p){
        List<Integer> ans = new ArrayList<>();
        int k = p.length();
        int[] farr = new int[26];
        for(int i = 0;i<p.length();i++){
            char ch = p.charAt(i);
            farr[ch-'a']++;
        }
        
        int left = 0;
        
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            farr[ch-'a']--;
            
            while(right-left+1>k){
                farr[s.charAt(left) - 'a']++;
                left++;
            }
            
            if(isEmpty(farr)){
                ans.add(left);
            }
        }
        return ans;
    }
    
    public boolean isEmpty(int[] arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}