import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new LinkedHashMap<>();

        int value = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), value++);
        }

        int i = 0;
        while (i < msg.length()) {
            StringBuilder w = new StringBuilder();

            while (i < msg.length() && map.containsKey(w.toString() + msg.charAt(i))) {
                w.append(msg.charAt(i));
                i++;
            }
            answer.add(map.get(w.toString()));

            if (i < msg.length()) {
                map.put(w.toString() + msg.charAt(i), value++);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}