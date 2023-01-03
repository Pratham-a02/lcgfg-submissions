class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1){
            return 0;
        }
        
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        primes[0] = primes[1] = false;
        
        int count = 0;
        for(int div = 2;div*div<=n;div++){
            if(primes[div] == false){
                continue;
            }
            
            for(int mult = div;div*mult<=n;mult++){
                primes[div*mult] = false;
            }
        }
        
        for(int i = 0;i<primes.length-1;i++){
            if(primes[i] == true){
                count++;
            }
        }
        
        return count;
    }
}