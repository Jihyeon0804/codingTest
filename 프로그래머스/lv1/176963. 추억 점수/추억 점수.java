import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        for (String[] p : photo) {
            int cnt = 0;
            for (String s : p) {
                cnt += map.getOrDefault(s, 0);
            }
            answer[idx++] = cnt;
        }
        return answer;
    }
}