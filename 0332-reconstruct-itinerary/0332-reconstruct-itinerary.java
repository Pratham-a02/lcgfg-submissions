class Solution {
    HashMap<String,PriorityQueue<String>> hm;
    public List<String> findItinerary(List<List<String>> tickets){
        hm = new HashMap<>();
        for(List<String> ticket:tickets){
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
    
    public void dfs(String v,List<String> ans){
        if(!hm.containsKey(v)){
            ans.add(0,v);
            return;
        }
        
        while(hm.get(v).size()>0){
            String nbr = hm.get(v).remove();
            dfs(nbr,ans);
        }
        ans.add(0,v);
        return;
    }
}