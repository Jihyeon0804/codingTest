class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int str_len = my_string.length();
        answer += my_string.substring(str_len - n, str_len);
        return answer;
    }
}