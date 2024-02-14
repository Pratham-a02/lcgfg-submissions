class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] ch = s.toCharArray();
        int shiftSum = 0;

        for (int i = shifts.length - 1; i >= 0; i--) {
            shiftSum = (shiftSum + shifts[i]) % 26;
            ch[i] = (char) ('a' + (ch[i] - 'a' + shiftSum) % 26);
        }

        return new String(ch);
    }
}