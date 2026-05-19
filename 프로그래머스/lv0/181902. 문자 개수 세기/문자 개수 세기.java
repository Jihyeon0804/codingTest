class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for (int i  = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            
            if (c >= 'A' && c <= 'Z') { // 대문자
                answer[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') { // 소문자
                answer[26 + c - 'a']++;
            }
        }
        
        return answer;
    }
}