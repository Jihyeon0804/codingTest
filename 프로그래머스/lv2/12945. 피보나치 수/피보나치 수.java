class Solution {
    public int solution(int n) {
        
        return fibo(n);
    }
    
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }

        int m = 0;
        int k = 1;
        int l = 0;
        for (int i = 2; i <= n; i++) {
            l = (m + k) % 1234567;
            m = k;
            k = l;
        }
        return l;
    }
}