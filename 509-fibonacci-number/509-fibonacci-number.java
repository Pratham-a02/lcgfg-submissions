class Solution {
    public int fib(int n) {
        return nthFibo(n,new HashMap<Integer,Integer>());
    }
    
    private int nthFibo(int n, HashMap<Integer,Integer> hm){
        if(n == 0 || n == 1){
            return n;
        }
        
        int currKey = n;
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        int a = nthFibo(n-1,hm);
        int b = nthFibo(n-2,hm);
        
        hm.put(currKey,a+b);
        return a+b;
    }
}