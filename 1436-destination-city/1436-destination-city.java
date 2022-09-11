class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> hm = new HashMap<>();
        for(int i = 0;i<paths.size();i++){
            hm.put(paths.get(i).get(0),paths.get(i).get(1));
        }
        
        for(int i = 0;i<paths.size();i++){
            if(hm.containsKey(paths.get(i).get(1))){
                continue;
            }
            else{
                return paths.get(i).get(1);
            }
        }
        return paths.get(paths.size()-1).get(1);
    }
}