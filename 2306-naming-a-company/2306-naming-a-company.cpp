typedef long long int ll;

class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        int n = ideas.size();
        vector<vector<ll>> cnt (26, vector<ll>(26, 0));
        
        unordered_set<string> all;
        for (auto i : ideas) all.insert(i);
        
        for (int j = 0; j < n; j ++) {
            char start = ideas[j][0];
            string left = ideas[j].substr(1);
            
            for (char ch = 'a'; ch <= 'z'; ch ++) {
                if (ch == start) continue;
                
                string x;
                x += ch;
                x += left;
                
                if (all.find(x) == all.end()) {
                    // cout << start << " " << ch << endl;
                    cnt[start-'a'][ch-'a'] ++;
                }
            }
        }
        
        ll ans = 0;
        for (int start = 0; start < 26; start ++) {
            for (int ed = 0; ed < 26; ed ++) {
                ans += cnt[start][ed]*cnt[ed][start];
            }
        }
        return ans;
    }
};