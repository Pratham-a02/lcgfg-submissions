class Solution {
    public String arrangeWords(String text){
        text = text.toLowerCase();
        TreeMap<Integer,List<String>> hm = new TreeMap<>();
        String[] arr = text.split(" ");
        for(String word:arr){
            if(!hm.containsKey(word.length())){
                hm.put(word.length(),new ArrayList<>());
            }
            List<String> curr = hm.get(word.length());
            curr.add(word);
            hm.put(word.length(),curr);
        }
        
        String res = "";
        for(int key:hm.keySet()){
            List<String> curr = hm.get(key);
            for(String word:curr){
                res += word + " ";
            }
        }
        res = res.substring(0, 1).toUpperCase() + res.substring(1);  
        return res.substring(0,res.length()-1);
    }
}