class Solution{
    HashMap<String,String> parent;
    HashMap<String,Double> mult;
    public void addDSU(String x){
        
            parent.put(x,x);
            mult.put(x,1.0);
        
    }
    
    public String find(String x){
        if(parent.get(x) == x){
            return parent.get(x);
        }
        else{
            String currparent = parent.get(x);
            String finalparent = find(currparent);
            
            parent.put(x,finalparent);
            
            mult.put(x,mult.get(currparent)*mult.get(x));
                    return finalparent;

        }
    }
    
    
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        parent = new HashMap<>();
        mult = new HashMap<>();
        
        for(List<String> eqn:equations){
            addDSU(eqn.get(0));
            addDSU(eqn.get(1));
        }
        int i = 0;
        for(List<String> eqn : equations){
            String l0 = find(eqn.get(0));
            String l1  = find(eqn.get(1));
            
            double m1 = mult.get(eqn.get(0));
            double m2 = mult.get(eqn.get(1));

            mult.put(l0,(m2*values[i])/m1);
            parent.put(l0,l1);
            i++;
        }
        i = 0;
        double[] res = new double[queries.size()];
        for(List<String> qu :queries){
            if(parent.containsKey(qu.get(0)) == false || parent.containsKey(qu.get(1)) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            String l0 = find(qu.get(0));
            String l1 = find(qu.get(1));
            
            if(l0.equals(l1) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            double m1 = mult.get(qu.get(0));
            double m2 = mult.get(qu.get(1));
            res[i] = m1/m2;
            i++;
        }
        return res;
    }
    
    
    
    
}