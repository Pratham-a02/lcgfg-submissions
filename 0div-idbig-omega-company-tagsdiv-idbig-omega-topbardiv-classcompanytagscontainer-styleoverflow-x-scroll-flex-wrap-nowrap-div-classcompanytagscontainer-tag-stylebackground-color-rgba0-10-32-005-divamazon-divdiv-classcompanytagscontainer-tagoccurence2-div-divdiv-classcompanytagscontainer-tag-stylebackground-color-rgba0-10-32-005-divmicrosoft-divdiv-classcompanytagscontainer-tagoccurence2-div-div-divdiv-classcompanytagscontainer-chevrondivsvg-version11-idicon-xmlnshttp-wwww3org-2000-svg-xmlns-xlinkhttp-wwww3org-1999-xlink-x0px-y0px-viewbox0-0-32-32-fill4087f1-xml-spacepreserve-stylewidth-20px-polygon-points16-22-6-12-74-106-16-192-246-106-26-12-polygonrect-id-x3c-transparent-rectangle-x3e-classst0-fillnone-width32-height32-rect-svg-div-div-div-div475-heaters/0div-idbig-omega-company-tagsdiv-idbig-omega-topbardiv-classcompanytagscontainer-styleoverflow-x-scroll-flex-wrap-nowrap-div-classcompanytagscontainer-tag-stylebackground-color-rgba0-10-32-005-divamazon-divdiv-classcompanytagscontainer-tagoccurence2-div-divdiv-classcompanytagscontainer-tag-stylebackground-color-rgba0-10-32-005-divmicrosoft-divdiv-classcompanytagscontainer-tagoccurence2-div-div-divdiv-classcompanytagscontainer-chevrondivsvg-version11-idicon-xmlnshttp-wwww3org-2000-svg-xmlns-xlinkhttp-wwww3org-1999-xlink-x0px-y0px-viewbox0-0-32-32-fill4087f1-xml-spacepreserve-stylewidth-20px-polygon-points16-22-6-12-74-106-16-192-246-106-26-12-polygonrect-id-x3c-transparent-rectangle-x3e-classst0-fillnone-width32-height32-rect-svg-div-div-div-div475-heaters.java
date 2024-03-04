class Pair{
    int js= -1;
    int jl= -1;
    Pair(){};
    Pair(int js,int jl){
        this.js = js;
        this.jl = jl;
    }
}
class Solution{
    public int findRadius(int[] houses,int[] heaters){
        Arrays.sort(heaters);
        int ans = 0;
        
        for(int i = 0;i<houses.length;i++){
            int hp = houses[i];
            
            Pair p = binarySearch(heaters,hp);
            int d1 = (p.js == -1)?Integer.MAX_VALUE:(hp-p.js);
            int d2 = (p.jl == -1)?Integer.MAX_VALUE:(p.jl-hp);
            
            int minD = Math.min(d1,d2);
            if(minD>ans){
                ans = minD;
            }
        }
        return ans;
    }
    
    public Pair binarySearch(int[] arr,int x){
        Pair p = new Pair();
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(arr[mid] == x){
                p.js = x;
                p.jl = x;
                break;
            }
            else if(arr[mid]<x){
                p.js = arr[mid];
                lo = mid+1;
            }
            else if(arr[mid]>x){
                p.jl = arr[mid];
                hi = mid-1;
            }
        }
        return p;
    }
}