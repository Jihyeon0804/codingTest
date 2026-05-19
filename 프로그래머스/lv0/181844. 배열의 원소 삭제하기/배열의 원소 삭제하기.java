import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            list.add(n);
        }

        for (int n : delete_list) {
            list.remove((Integer) n);
        }

        int[] answer = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            answer[idx++] = i;
        }
        return answer;
    }
}