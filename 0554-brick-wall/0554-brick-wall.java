class Solution{
    public int leastBricks(List<List<Integer>> wall){
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<wall.size();i++){
            int ps = 0;
            for(int j = 0;j<wall.get(i).size()-1;j++){
                ps += wall.get(i).get(j);
                
                hm.put(ps,hm.getOrDefault(ps,0)+1);
            }
        }
        if(hm.size() == 0){
            return wall.size();
        }
        int max = Collections.max(hm.values());
        
        return wall.size() - max;
    }
}