class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        for(String email : emails){
            String[] str = email.split("@");
            String res1 = "";
            for(int i = 0;i<str[0].length();i++){
                if(str[0].charAt(i) == '+'){
                    break;
                }
                else if(str[0].charAt(i) == '.'){
                    continue;
                }
                else{
                    res1 += str[0].charAt(i);
                }
            }
            System.out.println(res1);
            res1+="@";
            int idx = email.indexOf('@');
            String add = email.substring(idx+1,email.length());
            res1 += add;
            System.out.println(res1);
            hs.add(res1);
        }
        return hs.size();
    }
}