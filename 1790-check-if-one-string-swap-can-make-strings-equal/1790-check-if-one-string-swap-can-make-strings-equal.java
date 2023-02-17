class Solution{
    public boolean areAlmostEqual(String s1, String s2) {
      if(s1.equals(s2)){
          return true;
      }  
      List<Integer> al = new ArrayList<>();
      for(int i = 0;i<s1.length();i++){
          if(s1.charAt(i) != s2.charAt(i)){
              al.add(i);
          }
      }
      if(al.size() == 0){
          return true;
      }
      if(al.size() == 2){
          if(s1.charAt(al.get(0)) == s2.charAt(al.get(1)) && s1.charAt(al.get(1)) == s2.charAt(al.get(0))){
              return true;
          }
          else{
              return false;
          }
      }
      else{
          return false;
        }
    }
}