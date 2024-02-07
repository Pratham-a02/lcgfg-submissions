class Solution{
    public int numSpecialEquivGroups(String[] words){
        int count = 0;
        HashSet<String> hs = new HashSet<>();
        for(String word:words){
            String even = "";
            String odd = "";
            
            for(int i = 0;i<word.length();i++){
                if(i%2 == 0){
                    even += word.charAt(i);
                }
                else{
                    odd += word.charAt(i);
                }
            }
            
            even = sorted(even);
            odd = sorted(odd);
            
            hs.add(even + odd);
        }
        return hs.size();
    }
    
    public String sorted(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        return String.valueOf(arr);
    }
}