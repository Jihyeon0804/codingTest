class Solution {
    public int solution(int[] num_list) {
        int answer = (num_list.length < 11 ? 1 : 0);
        
        for (int n : num_list) {
            if (num_list.length < 11) {
                answer *= n;
            } else {
                answer += n;
            }
        }
        return answer;
    }
}