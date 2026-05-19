class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int cnt = 0;
        for (int num : num_list) {
            if (num < 0) {
                return answer;
            } else {
                cnt++;
            }
            answer++;
        }
        if (cnt == num_list.length) {
            answer = -1;
        }
        return answer;
    }
}