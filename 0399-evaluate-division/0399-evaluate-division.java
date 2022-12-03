class Solution {
    HashMap<String,String> parent;
    HashMap<String,Double> multi;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        multi = new HashMap<>();
        for(List<String>eqn:equations){
            addToDSU(eqn.get(0));
            addToDSU(eqn.get(1));
        }
        int i = 0;
        for(List<String> eqn:equations){
            String l0 = find(eqn.get(0));
            String l1 = find(eqn.get(1));
            
            double m0 = multi.get(eqn.get(0));
            double m1 = multi.get(eqn.get(1));
            
            multi.put(l0,(m1*values[i])/m0);
            parent.put(l0,l1);
            i++;
        }
        double[] res = new double[queries.size()];
        i = 0;
        for(List<String> query:queries){
            if(parent.containsKey(query.get(0)) == false || parent.containsKey(query.get(1)) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            String l0 = find(query.get(0));
            String l1 = find(query.get(1));
            
            if(l0.equals(l1) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            double m0 = multi.get(query.get(0));
            double m1 = multi.get(query.get(1));
            
            res[i] = m0/m1;
            i++;
        }
        return res;
    }
    
    public void addToDSU(String x){
        parent.put(x,x);
        multi.put(x,1.0);
    }
    
    public String find(String x){
        if(parent.get(x) == x){
            return parent.get(x);
        }
        else{
            String currparent = parent.get(x);
            String finalparent = find(currparent);
            
            parent.put(x,finalparent);
            
            multi.put(x,multi.get(currparent)*multi.get(x));
                    return finalparent;

        }
    }
}