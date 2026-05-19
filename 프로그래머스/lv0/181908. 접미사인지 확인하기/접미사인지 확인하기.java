import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        List<String> suffix_list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            suffix_list.add(my_string.substring(i));
        }
        
        return suffix_list.contains(is_suffix) ? 1 : 0;
    }
}