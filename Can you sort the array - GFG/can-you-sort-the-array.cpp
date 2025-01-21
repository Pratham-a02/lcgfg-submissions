//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    bool canSort(vector<int> &arr, vector<int> &frozen) {
        int n = arr.size();
        int cntZero = count(arr.begin(),arr.end(),0);
        
        for(int i = 0;i<n;i++){
            if(i<cntZero && arr[i] == 1 && frozen[i]){
                return false;
            }
            
            if(i>=cntZero && arr[i] == 0 && frozen[i]){
                return false;
            }
        }
        return true;
    }
};


//{ Driver Code Starts.

int main() {
    string str;
    getline(cin, str);
    int t = stoi(str);
    while (t--) {
        vector<int> arr, frozen;
        int x;

        getline(cin, str);
        stringstream ss1(str);
        while (ss1 >> x)
            arr.push_back(x);

        getline(cin, str);
        stringstream ss2(str);
        while (ss2 >> x)
            frozen.push_back(x);

        Solution ob;
        bool ans = ob.canSort(arr, frozen);
        if (ans) {
            cout << "true" << endl;
        } else {
            cout << "false" << endl;
        }
        cout << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends