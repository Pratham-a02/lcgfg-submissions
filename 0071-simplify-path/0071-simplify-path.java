class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        
        for(int i = 0;i<arr.length;i++){
            if(st.size()>0 && arr[i].equals("..")) st.pop();
            else if(!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals("..")){
                st.push(arr[i]);
            }
        }
        if(st.size() == 0){
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(st.size()>0){
            sb.insert(0,st.pop()).insert(0,"/");    
        }
        return sb.toString();
    }
}