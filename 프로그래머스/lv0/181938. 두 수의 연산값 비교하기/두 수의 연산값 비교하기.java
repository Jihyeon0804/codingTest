class Solution {
    public int solution(int a, int b) {
        int sum1 = Integer.parseInt("" + a + b);
        if (sum1 > 2 * a * b || sum1 == 2 * a * b) {
            return sum1;
        } else {
            return 2 * a * b;
        }
    }
}