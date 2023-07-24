class Solution{
    public List<List<String>> groupAnagrams(String[] strs){
         List<List<String>> ans = new ArrayList<>();
        
        HashMap<HashMap<Character,Integer>,List<String>> hm = new HashMap<>();
        
        for(String str : strs){
            HashMap<Character,Integer> curr = new HashMap<>();
            
            for(int i = 0;i<str.length();i++){
                char ch = str.charAt(i);
                
                curr.put(ch,curr.getOrDefault(ch,0)+1);
            }
                if(hm.containsKey(curr)){
                    List<String> al = hm.get(curr);
                    al.add(str);
                }
                else{
                    List<String> al = new ArrayList<>();
                    al.add(str);
                    hm.put(curr,al);
                }
            }
        
        
        for(List<String> curr :hm.values()){
            ans.add(curr);
        }
        return ans;
    }
}