//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    ArrayList<String> ans;
    int n;
    public ArrayList<String> genIp(String s) {
        ans = new ArrayList<>();
        n = s.length();
        if(n>12 || n<4){
            ArrayList<String> curr = new ArrayList<>();
            curr.add("-1");
            return curr;
        }
        solve(0,0,"",s);
        return ans;
    }
    
    public void solve(int idx,int parts,String curr,String s){
        if(idx == n && parts == 4){
            curr = curr.substring(0,curr.length()-1);
            ans.add(curr);
            // return ans;
        }
        
        if(idx+1<=n){
            solve(idx+1,parts+1,curr + s.substring(idx,idx+1) + ".",s);
        }
        if(idx+2<=n && isValid(s.substring(idx,idx+2))){
            solve(idx+2,parts+1,curr + s.substring(idx,idx+2) + ".",s);
        }
        if(idx+3<=n && isValid(s.substring(idx,idx+3))){
            solve(idx+3,parts+1,curr + s.substring(idx,idx+3) + ".",s);
        }
    }
    
    public boolean isValid(String s){
        if(s.charAt(0) == '0' || Integer.valueOf(s)>255){
            return false;
        }
        return true;
    }
}