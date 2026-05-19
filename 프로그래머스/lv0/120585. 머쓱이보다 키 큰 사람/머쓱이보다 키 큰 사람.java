class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int n : array) {
            if (n > height) {
                answer++;
            }
        }
        return answer;
    }
}