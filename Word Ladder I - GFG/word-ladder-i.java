//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Solution{
    public int wordLadderLength(String startWord,String targetWord,String[] wordList){
        if(Arrays.asList(wordList).contains(targetWord) == false){
            return 0;
        }
        
        HashMap<String,Boolean> hm = new HashMap<>();
        ArrayDeque<String> qu = new ArrayDeque<>();
        for(String word:wordList){
            hm.put(word,false);
        }
        
        int length = 1;
        hm.put(startWord,true);
        qu.add(startWord);
        
        while(qu.size()>0){
            int csize = qu.size();
            
            for(int i = 0;i<csize;i++){
                String currWord = qu.remove();
                
                if(currWord.equals(targetWord)){
                    return length;
                }
                
                addWord(currWord,hm,qu);
            }
            length++;
        }
        return 0;
    }
    
    public void addWord(String currWord,HashMap<String,Boolean> hm,ArrayDeque<String> qu){
        for(int i = 0;i<currWord.length();i++){
            
            char[] arr = currWord.toCharArray();
            
            for(int j = 0;j<26;j++){
                char c = (char)('a' + j);
                
                arr[i] = c;
                
                String s = String.valueOf(arr);
                
                if(hm.containsKey(s) && hm.get(s) == false){
                    qu.add(s);
                    hm.put(s,true);
                }
            }
        }
        return;
    }
}