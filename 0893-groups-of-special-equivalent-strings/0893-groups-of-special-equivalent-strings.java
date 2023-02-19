class Solution {
    public int numSpecialEquivGroups(String[] words) {
        HashSet<String> hs = new HashSet<>();
        for(String word:words){
            String odd = "";
            String even = "";
            for(int i = 0;i<word.length();i++){
                if(i%2 == 0){
                    even += word.charAt(i);
                }
                else{
                    odd += word.charAt(i);
                }
            }
            
            odd = sorted(odd);
            even = sorted(even);
            
            hs.add(odd+even);
        }
        return hs.size();
    }
    
    public String sorted(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}