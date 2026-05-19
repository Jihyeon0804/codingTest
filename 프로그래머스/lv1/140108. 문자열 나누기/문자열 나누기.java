class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (s.length() > 0 && idx1 < s.length()) {
            char target = s.charAt(idx1);
            int cnt1 = 0;
            int cnt2 = 0;
            for (; idx1 < s.length(); idx1++) {
                if (s.charAt(idx1) == target) {
                    cnt1++;
                } else {
                    cnt2++;
                }

                if (cnt1 == cnt2) {
                    idx2 = ++idx1;
                    answer++;
                    break;
                }
            }

        }

        if (idx2 < s.length()) {
            answer++;
        }
        return answer;
    }
}