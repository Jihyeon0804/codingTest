import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> num_list = new ArrayList<>();
        int cur = n;
        while (cur > 1) {
            num_list.add(cur);
            if (cur % 2 == 0) {
                cur /= 2;
            } else {
                cur = 3 * cur + 1;
            }
            
        }
        num_list.add(cur);
        int[] answer = num_list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}