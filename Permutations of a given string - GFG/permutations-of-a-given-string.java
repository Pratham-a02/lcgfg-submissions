//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<>();
        printPermutations(S,"",ans);
        Collections.sort(ans);
        return ans;
    }
    
    public static void printPermutations(String str, String asf,List<String> ans) {
        if(str.length() == 0){
            if(!ans.contains(asf)){
                 ans.add(asf);
            }
            return;
        }
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);
            printPermutations(ros,asf+ch,ans);
        }
    }

}