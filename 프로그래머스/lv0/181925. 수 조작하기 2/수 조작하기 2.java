class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int cnt = numLog.length;
        int i = 1;
        while (cnt > 0 && i < numLog.length) {
            switch (numLog[i] - numLog[i-1]) {
                case 1:
                    answer += 'w';
                    break;
                case -1:
                    answer += 's';
                    break;
                case 10:
                    answer += 'd';
                    break;
                case -10:
                    answer += 'a';
                    break;
            }
            cnt--;
            i++;
        }
        
        return answer;
    }
}