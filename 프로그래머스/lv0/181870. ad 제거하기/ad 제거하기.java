import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        
        for (String str : strArr) {
            if (str.contains("ad") == false) {
                list.add(str);
            }
        }

        String[] answer = new String[list.size()];
        int idx = 0;
        for (String str : list) {
            answer[idx++] = str;
        }
        return answer;
    }
}