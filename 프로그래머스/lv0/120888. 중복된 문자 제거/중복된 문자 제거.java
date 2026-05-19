import java.util.*;

class Solution {
    public String solution(String my_string) {
        String[] stringArr = my_string.split("");

        Set<String> set = new LinkedHashSet<>(Arrays.asList(stringArr));
       
        String answer = String.join("", set);
        return answer;
    }
}