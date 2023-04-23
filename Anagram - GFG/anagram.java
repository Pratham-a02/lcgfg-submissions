//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution{    
    public static boolean isAnagram(String a,String b){
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<a.length();i++){
            hm.put(a.charAt(i),hm.getOrDefault(a.charAt(i),0)+1);
        }
        
        for(int i = 0;i<b.length();i++){
            char ch = b.charAt(i);
            
            if(!hm.containsKey(ch)){
                return false;
            }
            
            hm.put(ch,hm.get(ch)-1);
            
            if(hm.get(ch) == 0){
                hm.remove(ch);
            }
        }
        
        return true;
    }
}