import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        for (String rec : record) {
            String[] split = rec.split(" ");
            if (split.length == 3) {
                map.put(split[1], split[2]);
            }
        }

        for (String rec : record) {
            String[] split = rec.split(" ");
            if (split[0].equals("Enter")) {
                answer.add( map.get(split[1]) + "님이 들어왔습니다.");
            } else if (split[0].equals("Leave")) {
                answer.add(map.get(split[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}