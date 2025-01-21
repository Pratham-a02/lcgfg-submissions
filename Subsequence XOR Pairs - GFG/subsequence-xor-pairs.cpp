//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
  
    void helper(int idx,int currXor,int count,vector<int>&arr,map<int,int> &map){
        if(idx == arr.size()){
            if(count>0){
                map[currXor]++;
            }
            return;
        }
        
        helper(idx+1,currXor^arr[idx],count+1,arr,map);
        helper(idx+1,currXor,count,arr,map);
        
        return;
    }
    
    int xorPair(vector<int>& arr) {
        map<int,int> freqMap;
        helper(0,0,0,arr,freqMap);
        
        const int MOD = 1e9 + 7;
        long long ans = 0;
        
        for(auto& it:freqMap){
            long long count = it.second;
            long long pairs = (count*(count-1))/2;
            ans = (ans + pairs%MOD)%MOD;
        }
        
        return (int)ans;
    }
};

//{ Driver Code Starts.

int main() {
    int tt;
    cin >> tt;
    cin.ignore();
    while (tt--) {
        string s;
        getline(cin, s);
        stringstream ss(s);
        int v;
        vector<int> a;
        while (ss >> v) {
            a.push_back(v);
        }
        Solution ob;
        cout << ob.xorPair(a) << endl;
        cout << "~" << endl;
    }
}
// } Driver Code Ends