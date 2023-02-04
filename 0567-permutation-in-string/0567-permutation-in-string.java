class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] farr = new int[26];
        for(int i = 0;i<s1.length();i++){
            char ch = s1.charAt(i);
            farr[ch-'a']++;
        }
        int left = 0;
        for(int right = 0;right<s2.length();right++){
            char ch = s2.charAt(right);
            farr[ch-'a']--;
            while(right-left+1>s1.length()){
                farr[s2.charAt(left)-'a']++;
                left++;
            }
            
            if(isEmpty(farr)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty(int[] arr){
        boolean flag = true;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}