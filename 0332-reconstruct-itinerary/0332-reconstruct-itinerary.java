class Solution {
    HashMap<String,PriorityQueue<String>>hm;
    public List<String> findItinerary(List<List<String>> tickets) {
        hm = new HashMap<>();
        
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            if(hm.containsKey(src)){
                hm.get(src).add(dest);
            }
            else{
                hm.put(src,new PriorityQueue<>());
                hm.get(src).add(dest);
            }
        }
        
        List<String> ans = new ArrayList<>();
        dfs("JFK",ans);
        return ans;
    }
    
    public void dfs(String src,List<String> ans){
        if(!hm.containsKey(src) || hm.get(src).size() == 0){
            ans.add(0,src);
            return;
        }
        
        while(hm.get(src).size()>0){
            String nbr = hm.get(src).remove();
            
            dfs(nbr,ans);
        }
        ans.add(0,src);
    }
}