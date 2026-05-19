class Solution {
    public int solution(int order) {
        
        int answer = 0;
        String str = String.valueOf(order);
        for (char c : str.toCharArray()) {
            if (c == '3' || c == '6' || c == '9') {
                answer++;
            }
        }
        return answer;
    }
}