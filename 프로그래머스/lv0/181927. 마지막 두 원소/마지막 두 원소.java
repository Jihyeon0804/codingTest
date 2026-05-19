import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int list_len = num_list.length;
        List<Integer> num_toList = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        if (num_list[list_len - 1] > num_list[list_len - 2]) {
            num_toList.add(num_list[list_len - 1] - num_list[list_len - 2]);
        } else {
            num_toList.add(num_list[list_len - 1] * 2);
        }
        Integer[] integerArr = num_toList.toArray(new Integer[num_list.length + 1]);
        answer = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}