class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (b, a) -> Integer.compare(a[k], b[k]));
        return score;
    }
}