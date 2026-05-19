class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            char[] cArray = targets[i].toCharArray();
            int cnt = 0;
            for (char c : cArray) {
                int minIdx = 100;
                for (String key : keymap) {
                    if (key.indexOf(c) < minIdx && key.indexOf(c) != -1) {

                        minIdx = key.indexOf(c) + 1;
                    }
                }

                if (minIdx >= 100) {
                    cnt = -1;
                    break;
                } else {
                    cnt += minIdx;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}