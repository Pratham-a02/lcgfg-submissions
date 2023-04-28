class Solution {
    public int numSimilarGroups(String[] strs) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            parent.put(strs[i],strs[i]);
            rank.put(strs[i],1);
        }
        
        for(int i = 0;i<strs.length;i++){
            for(int j = i+1;j<strs.length;j++){
                String first = strs[i];
                String second = strs[j];
                int idx = 0;
                int count = 0;

                while(idx<first.length()){
                    if(first.charAt(idx) != second.charAt(idx)){
                        count++;
                    }
                    idx++;
                }
                if(count == 2){
                String firstLead = find(first);
                String secondLead = find(second);
                
                if(firstLead.equals(secondLead) == false){
                    union(firstLead,secondLead);
                }
              }
            }
            
        }
        
        int res = 0;
        for(String key:parent.keySet()){
            if(parent.get(key).equals(key)){
                res++;
            }
        }
        return res;
    }
    
    HashMap<String,String> parent;
    HashMap<String,Integer> rank;
    
    public String find(String x){
        if(parent.get(x).equals(x)){
            return parent.get(x);
        }
        else{
            String finalParent = find(parent.get(x));
            parent.put(x,finalParent);
            return finalParent;
        }
    }
    
    
    public void union(String fLead,String sLead){
        if(rank.get(fLead)>rank.get(sLead)){
            parent.put(sLead,fLead);
            // rank.put(fLead,rank.get(fLead)+1);
        }
        else if(rank.get(sLead)>rank.get(fLead)){
            parent.put(fLead,sLead);
            // rank.put(sLead,rank.get(sLead)+1);
        }
        else{
            parent.put(sLead,fLead);
            rank.put(fLead,rank.get(fLead)+1);
        }
    }
}