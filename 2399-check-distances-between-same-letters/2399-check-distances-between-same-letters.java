class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(arr[ch - 'a'] != -1){
                if(distance[ch-'a'] == i - arr[ch-'a'] -1){
                    continue;
                }
                else if(distance[ch-'a'] != i - arr[ch-'a'] -1){
                    return false;
                    // break;
                }
            }
            else{
                arr[ch - 'a'] = i;
            }
        }
        return true;
    }
}