class Solution {
    public String solution(int n, int t, int m, int p) {
        
        int num = 0;
        StringBuilder str = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        

        while (str.length() <= t * m) { // 진수 변환 + 대문자 변경
            str.append(Integer.toString(num++, n));
        }
        
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(str.charAt(i));
        }
        
        return answer.toString().toUpperCase();
    }
}