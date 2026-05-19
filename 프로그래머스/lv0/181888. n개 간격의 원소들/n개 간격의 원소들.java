import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num_list.length; i += n) {
            list.add(num_list[i]);
        }
        int[] answer = new int[list.size()];
        int idx = 0;
        for (int num : list) {
            answer[idx++] = num;
        }
        return answer;
    }
}