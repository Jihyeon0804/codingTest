class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i < 100 / 6; i++) {
            if (n % 6 == 0) {
                answer = n / 6;
            } else {
                if ((n * i) % 6 == 0) {
                    answer = (n * i) / 6;
                    break;
                }
            }
        }
        return answer;
    }
}