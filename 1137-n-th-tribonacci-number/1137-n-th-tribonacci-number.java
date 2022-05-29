class Solution {
    public int tribonacci(int n) {
        return nthTribo(n,new HashMap<Integer,Integer>());
    }
    
    private int nthTribo(int n, HashMap<Integer,Integer> hm){
        if(n == 0 || n==1){
            return n;
        }
        if(n==2){
            return 1;
        }
        
        int currKey = n;
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        int a = nthTribo(n-1,hm);
        int b = nthTribo(n-2,hm);
        int c = nthTribo(n-3,hm);
        
        hm.put(currKey,a+b+c);
        
        return a+b+c;
    }
    
}