class Solution{
    public List<Integer> partitionLabels(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);    
            hm.put(ch,i);
        }
        
        int st = 0;
        int end = 0;
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            end = Math.max(end,hm.get(ch));
            
            if(i == end){
                ans.add(end-st+1);
                end = st = i+1;
            }
        }
        
        return ans;
    }
}