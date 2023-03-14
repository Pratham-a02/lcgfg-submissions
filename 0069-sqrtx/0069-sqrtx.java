class Solution {
    public int mySqrt(int x) {
        long ans = 0;
		long lo = 1;
		long hi = x;
		while(lo<=hi){
		    long mid = lo - (lo-hi)/2;
		    
		    if(mid*mid == x){
		        return (int)mid;
		    }
		    else if(mid*mid<x){
		        ans = mid;
		        lo = mid+1;
		    }
		    else{
		        hi = mid-1;
		    }
		}
		return (int)ans;
    }
}