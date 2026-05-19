import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int start_num, int end_num) {
        
        List<Integer> num_list = IntStream.range(start_num, end_num + 1)
            .boxed().collect(Collectors.toList());
        
        int[] answer = num_list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}