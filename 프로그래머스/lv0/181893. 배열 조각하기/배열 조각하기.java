import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            list.add(n);
        }
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                list = list.subList(0, query[i] + 1);
            } else {
                list = list.subList(query[i], list.size());
            }
        }
        
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}