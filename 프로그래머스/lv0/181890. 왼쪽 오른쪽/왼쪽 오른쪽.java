import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        int idx = 0;
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l") || str_list[i].equals("r")) {
                idx = i;
                break;
            } 
        }
        List<String> list = new ArrayList<>();
        if (str_list[idx].equals("l")) {
            for (int i = 0; i < idx; i++) {
                list.add(str_list[i]);
            }
            return list.toArray(new String[list.size()]);
            
        } else if (str_list[idx].equals("r")) {
            for (int i = idx + 1; i < str_list.length; i++) {
                list.add(str_list[i]);
            }
            return list.toArray(new String[list.size()]);
            
        }
        return answer;
    }
}