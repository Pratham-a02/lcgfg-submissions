// { Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function template for C++

class Solution{   
public:
    bool helper(vector<int>&arr, int currIdx, int currSum, int targetSum, vector<vector<int>>&dp){
        if(currSum == targetSum)    return true;
        if(currSum > targetSum) return false;
        if(currIdx==arr.size()) return false;
        
        // string key = currIdx+"_"+currSum;
        // if(dp.find(key)!=dp.end())  return dp[key];
        if(dp[currIdx][currSum]!=-1)    return dp[currIdx][currSum];
        
        bool includeRes = helper(arr, currIdx+1, currSum+arr[currIdx], targetSum, dp);
        bool excludeRes = helper(arr, currIdx+1, currSum, targetSum, dp);
        
        return dp[currIdx][currSum] = includeRes || excludeRes;
    }

    bool isSubsetSum(vector<int>arr, int sum){
        vector<vector<int>> dp(arr.size()+1,vector<int>(sum+1,-1));
        return helper(arr, 0, 0, sum, dp);
    }
};

// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N, sum;
        cin >> N;
        vector<int> arr(N);
        for(int i = 0; i < N; i++){
            cin >> arr[i];
        }
        cin >> sum;
        
        Solution ob;
        cout << ob.isSubsetSum(arr, sum) << endl;
    }
    return 0; 
} 
  // } Driver Code Ends