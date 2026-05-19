class Solution {
    public String solution(String code) {
        String answer = "";
        char[] code_arr = code.toCharArray();
        int mode = 0;
        for (int idx = 0; idx < code_arr.length; idx++) {
            if (mode == 0) {
                if (code_arr[idx] != '1' && idx % 2 == 0) {
                    answer += code_arr[idx];
                } else if (code_arr[idx] == '1') {
                    mode = 1;
                }
            } else if (mode == 1) {
                if (code_arr[idx] != '1' && idx % 2 == 1) {
                    answer += code_arr[idx];
                } else if (code_arr[idx] == '1') {
                    mode = 0;
                }
            }
            
        }
        
        return answer.isEmpty() ? "EMPTY" : answer;
    }
}