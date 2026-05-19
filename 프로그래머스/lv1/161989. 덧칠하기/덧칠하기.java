import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int s : section) {
            list.add(s);
        }

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (section[list.size() - 1] - section[i] + 1 <= m) {
                    answer++;
                    list.subList(i, list.size()).clear();
                }
            }
        }
        return answer;
    }
}