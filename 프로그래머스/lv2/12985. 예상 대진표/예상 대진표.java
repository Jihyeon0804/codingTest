class Solution {
    public int solution(int n, int a, int b) {
        
        int answer = Integer.toBinaryString(n).length() - 1;
        
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (true) {
            if (a <= n / 2 && b > n / 2) {
                return answer;
            } else if (a <= n / 2 && b <= n / 2) {
                n -= (int) Math.pow(2, --answer);
            } else {
                n += (int) Math.pow(2, --answer);
            }
        }
    }
}