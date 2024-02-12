class Solution{
    public boolean checkInclusion(String s1,String s2){
        int k = s1.length();
        int[] farr = new int[26];
        
        for(int i = 0;i<s1.length();i++){
            char ch = s1.charAt(i);
            farr[ch-'a']++;
        }
        
        int left = 0;
        for(int right = 0;right<s2.length();right++){
            char ch = s2.charAt(right);
            farr[ch-'a']--;
            while(right-left+1 > k){
                farr[s2.charAt(left) - 'a']++;
                left++;
            }
            
            if(isEmpty(farr)){
                return true;
            }
        }                   
        return false;
    }
    
    public boolean isEmpty(int[] arr){
        for(int val:arr){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}