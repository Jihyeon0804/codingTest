class Solution {
    public int solution(int n) {
        int prev = 1, curr = 1;

        for (int i = 2; i <= n; i++) {
            int next = (prev + curr) % 1000000007;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
}
