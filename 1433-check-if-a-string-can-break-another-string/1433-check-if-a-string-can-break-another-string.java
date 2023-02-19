class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int n = s1.length();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String str1 = String.valueOf(arr1);
        String str2 = String.valueOf(arr2);
        
        int i = 0;
        while(i<str1.length() && str1.charAt(i)>=str2.charAt(i)){
            i++;
        }
        if(i == n){
            return true;
        }
        
        i = 0;
        while(i<n && str2.charAt(i)>=str1.charAt(i)){
            i++;
        }
        if(i == n){
            return true;
        }
        
        return false;
    }
}