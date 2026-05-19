class Solution {
    public int solution(int n) {
        int answer = 0;
       
        int oneCount = Integer.bitCount(n); // 1의 개수

        for (int i = n + 1; i <= 1000000; i++) {
            if (Integer.bitCount(i) == oneCount) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}