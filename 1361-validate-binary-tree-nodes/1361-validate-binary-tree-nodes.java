class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<List<Integer>> parentTochild = new ArrayList<>();
        List<List<Integer>> childToparent = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            parentTochild.add(new ArrayList<>());
            childToparent.add(new ArrayList<>());
        }
        /* For handling multiple parents*/
        for(int i = 0;i<n;i++){
            int leftC = leftChild[i];
            int rightC = rightChild[i];
            
            if(leftC != -1){
                parentTochild.get(i).add(leftC);
                
                if(childToparent.get(leftC).size() == 0){
                    childToparent.get(leftC).add(i);
                }else{
                    return false;
                }
            }
            
            if(rightC != -1){
                parentTochild.get(i).add(rightC);
                
                if(childToparent.get(rightC).size() == 0){
                    childToparent.get(rightC).add(i);
                }else{
                    return false;
                }
            }
        }
        /* For handling multiple parents*/
        
        Integer rootCandidate = null;
        
        for(int i = 0;i<childToparent.size();i++){
            if(childToparent.get(i).size() == 0){
                if(rootCandidate == null){
                    rootCandidate = i;
                }else{
                    return false;
                }
            }
        }
        
        if(rootCandidate == null){
            return false;
        }
        HashSet<Integer> hs = new HashSet<>();
        dfs(rootCandidate,hs,parentTochild);
        return hs.size()==n;
    }
    
    public void dfs(int src,HashSet<Integer> hs,List<List<Integer>> graph){
        hs.add(src);
        
        for(int nbr:graph.get(src)){
            if(!hs.contains(nbr)){
                dfs(nbr,hs,graph);
            }
        }
    }
}