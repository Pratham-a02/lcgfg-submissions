class Solution{
    HashMap<String,String> parent;
    HashMap<String,Double> multiplier;
    
    public void addToDSU(String x){
        if(!parent.containsKey(x)){
            parent.put(x,x);
            multiplier.put(x,1.0);
        }
    }
    
    public String find(String x){
        if(parent.get(x).equals(x)){
            return parent.get(x);
        }
        else{
            String cp = parent.get(x);
            String fp = find(cp);
            
            parent.put(x,fp);
            multiplier.put(x,multiplier.get(x)*multiplier.get(cp));
            
            return fp;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations,double[] values,List<List<String>>queries){
        parent = new HashMap<>();
        multiplier = new HashMap<>();
        
        for(List<String> eqn : equations){
            addToDSU(eqn.get(0));
            addToDSU(eqn.get(1));
        }
        int idx = 0;
        for(List<String> eqn : equations){
            String l0 = find(eqn.get(0));
            String l1 = find(eqn.get(1));
            
            if(l0.equals(l1) == false){
                //union
                
                double m1 = multiplier.get(eqn.get(0));
                double m2 = multiplier.get(eqn.get(1));
                
                parent.put(l0,l1);
                multiplier.put(l0,(m2*values[idx++]/m1));
            }
        }
        
        idx = 0;
        double[] res = new double[queries.size()];
        for(List<String> query : queries){
            String q0 = query.get(0);
            String q1 = query.get(1);
            
            if(!parent.containsKey(q0) || !parent.containsKey(q1)){
                res[idx] = -1;
                idx++;
                continue;
            }
            
            String l0 = find(q0);
            String l1 = find(q1);
            
            if(l0.equals(l1) == false){
                res[idx] = -1;
                idx++;
                continue;
            }
            
            double m0 = multiplier.get(q0);
            double m1 = multiplier.get(q1);
            res[idx] = m0/m1;
            idx++;
        }
        
        return res;
    }
}