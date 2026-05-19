import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (s.isEmpty() == false) {
                list.add(s);
            }
        }
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            answer[idx++] = s;
        }
        Arrays.sort(answer);
        return answer;
    }
}