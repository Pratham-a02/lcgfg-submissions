//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string findKth(int k, long long n) {
        int l = 1;
        --n;
        
        while(n-pow(k,(l+1)/2) >= 0){
            n -= pow(k,(l+1)/2);
            ++l;
        }
        
        string s = "";
        while(n>0){
            s += (char)('a' + n%k);
            n/=k;
        }
        
        while(2*s.size() < l){
            s += 'a';
        }
        
        string t = s;
        reverse(s.begin(),s.end());
        
        if(l&1) s.pop_back();
        
        s+= t;
        return s;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int k;
        scanf("%d", &k);

        long long n;
        scanf("%lld", &n);

        Solution obj;
        string res = obj.findKth(k, n);

        cout << res << "\n";
    }
}

// } Driver Code Ends