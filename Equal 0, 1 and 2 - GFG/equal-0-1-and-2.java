//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends

class Solution{ 
    long getSubstringWithEqual012(String str){ 
        HashMap<String,Integer> hm = new HashMap<>();
        int zc = 0;
        int oc = 0;
        int tc = 0;
        
        String s = (oc-zc) + "#" + (tc-oc);
        hm.put(s,1);
        long ans = 0;
        
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if(ch == '0'){
                zc++;
            }
            else if(ch == '1'){
                oc++;
            }
            else{
                tc++;
            }
            
            String curr = (oc-zc) + "#" + (tc-oc);
            if(hm.containsKey(curr)){
                ans += hm.get(curr);
            }
            
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }
        return ans;
    }
} 