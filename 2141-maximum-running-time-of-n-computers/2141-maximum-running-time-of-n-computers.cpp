class Solution {
public:
    typedef long long ll;
    long long maxRunTime(int n, vector<int>& batteries) {
        
        ll l = *min_element(begin(batteries),end(batteries));
        
        ll sum_total_minutes = 0;
        
        for(auto &mints:batteries){
            sum_total_minutes += mints;
        }
        ll r = sum_total_minutes/n;
        ll result = 0;
        while(l<=r){
            ll mid = l + (r-l)/2;
            
            if(possible(mid,batteries,n)){
                result = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return result;
    }
    
    bool possible(ll mid,vector<int>&batteries,int n){
        ll limit = mid*n;
        
        ll currSum = 0;
        
        for(int i = 0;i<batteries.size();i++){
            currSum += min((ll)batteries[i],mid);
            if(currSum>=limit){
                return true;
            }
        }
        
        return false;
    }
};