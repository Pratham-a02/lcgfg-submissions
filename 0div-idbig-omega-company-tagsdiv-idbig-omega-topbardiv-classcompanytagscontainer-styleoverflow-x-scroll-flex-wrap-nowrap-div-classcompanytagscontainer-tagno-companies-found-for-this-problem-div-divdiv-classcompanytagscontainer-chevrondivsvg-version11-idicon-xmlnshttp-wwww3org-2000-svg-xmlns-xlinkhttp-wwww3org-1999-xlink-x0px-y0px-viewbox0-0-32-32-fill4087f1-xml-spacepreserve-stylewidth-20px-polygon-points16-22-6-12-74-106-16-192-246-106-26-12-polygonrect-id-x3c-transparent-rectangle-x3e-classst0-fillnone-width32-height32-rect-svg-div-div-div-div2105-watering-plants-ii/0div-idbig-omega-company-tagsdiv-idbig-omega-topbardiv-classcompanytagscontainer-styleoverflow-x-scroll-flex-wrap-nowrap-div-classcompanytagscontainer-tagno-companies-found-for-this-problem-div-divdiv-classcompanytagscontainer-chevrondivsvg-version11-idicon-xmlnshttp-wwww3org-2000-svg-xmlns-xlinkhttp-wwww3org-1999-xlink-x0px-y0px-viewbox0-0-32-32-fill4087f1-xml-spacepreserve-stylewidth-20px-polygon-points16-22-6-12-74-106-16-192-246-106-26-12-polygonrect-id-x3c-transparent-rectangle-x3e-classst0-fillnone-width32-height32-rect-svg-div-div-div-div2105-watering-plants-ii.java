class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int lo = 0;
        int hi = plants.length-1;
        
        int currA = capacityA;
        int currB = capacityB;
        int ans = 0;
        
        while(lo<=hi){
            if(currA<plants[lo]){
                currA = capacityA;
                ans++;
            }
            
            if(currB < plants[hi]){
                currB = capacityB;
                ans++;
            }
            
            currA -= plants[lo];
            lo++;
            currB -= plants[hi];
            hi--;
            
            if(lo == hi){
                if(currA == currB || currA>currB){
                    if(currA < plants[lo]){
                        ans++;
                    }
                    lo++;
                }
                else{
                    if(currB < plants[hi]){
                        ans++;
                    }
                    hi--;
                }
            }
        }
        return ans;
    }
}