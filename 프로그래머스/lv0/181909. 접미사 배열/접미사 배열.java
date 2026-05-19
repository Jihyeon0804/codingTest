import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        List<String> str_list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            str_list.add(my_string.substring(i));
        }
        Collections.sort(str_list);
        return str_list.toArray(new String[str_list.size()]);
    }
}