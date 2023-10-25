class Pair{
    int id;
    int st;
    int ct;
    Pair(){};
    Pair(int id,int st,int ct){
        this.id = id;
        this.st = st;
        this.ct = ct;
    }
}
class Solution{
    public int[] exclusiveTime(int n,List<String> logs){
       Stack<Pair> st = new Stack<>();
       int[] ans = new int[n];
        
       for(int i = 0;i<logs.size();i++){
           String[] log = logs.get(i).split(":");
           
           if(log[1].equals("start")){
               Pair p = new Pair();
               p.id = Integer.parseInt(log[0]);
               p.st = Integer.parseInt(log[2]);
               p.ct = 0;
               st.push(p);
           }
           else{
               Pair p = st.pop();
               int interval = Integer.parseInt(log[2]) - p.st + 1;
               int time = interval - p.ct;
               ans[p.id] += time;
               
               if(st.size()>0){
                   st.peek().ct += interval;
               }
           }
       }
        
        return ans;
    }
}