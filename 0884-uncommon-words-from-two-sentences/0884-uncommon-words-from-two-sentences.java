class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(String s:arr1){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        for(String s:arr2){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        
        List<String> al = new ArrayList<>();
        for(String s:hm.keySet()){
            if(hm.get(s) == 1){
                al.add(s);
            }
        }
        String[] result = new String[al.size()];
        return al.toArray(result);
    }
}