class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int start = i; start <= j; start++) {
            char[] arr = String.valueOf(start).toCharArray();
            for (char c : arr) {
                if (String.valueOf(c).equals(String.valueOf(k))) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}