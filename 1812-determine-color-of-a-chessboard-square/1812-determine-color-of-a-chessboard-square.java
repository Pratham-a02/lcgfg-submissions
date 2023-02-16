class Solution {
    public boolean squareIsWhite(String coordinates) {
        List<Character> al1 = new ArrayList<>();
        al1.add('a');
		al1.add('c');
		al1.add('e');
		al1.add('g');
        List<Character> al2 = new ArrayList<>();
        al2.add('b');
		al2.add('d');
		al2.add('f');
		al2.add('h');
        if(al1.contains(coordinates.charAt(0))){
            int val = coordinates.charAt(1) - '0';
            if(val%2 != 0){
                return false;
            }
            else{
                return true;
            }
        }
        else if(al2.contains(coordinates.charAt(0))){
            int val = coordinates.charAt(1) - '0';
            if(val%2 == 0){
                return false;
            }
            else{
                return true;
            }
        }
        return true;
    }
}