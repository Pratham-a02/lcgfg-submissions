class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character,Integer>,List<String>> hm = new HashMap<>();
        
        for(String str:strs){
            HashMap<Character,Integer> hm1 = new HashMap<>();
            for(int i = 0;i<str.length();i++){
                hm1.put(str.charAt(i),hm1.getOrDefault(str.charAt(i),0)+1);
            }
            
            if(hm.containsKey(hm1)){
                List<String> curr = hm.get(hm1);
                curr.add(str);
            }
            else{
                List<String> curr = new ArrayList<>();
                curr.add(str);
                hm.put(hm1,curr);
            }
        }
        
        for(List<String> curr :hm.values()){
            ans.add(curr);
        }
        return ans;
    }
}