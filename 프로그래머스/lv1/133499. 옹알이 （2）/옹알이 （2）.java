class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        
        int answer = 0;
        
        for (String s : babbling) {
            for (String w : words) {

                if (s.contains(w.repeat(2))) {
                    s = s.replace(w.repeat(2), "r");
                }

                if (s.contains(w)) {
                    s = s.replace(w, " ");
                }
            }

            s = s.replace(" ", "");
            if (s.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}