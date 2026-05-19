import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        int start_idx = Arrays.asList(array).indexOf(2);
        int end_idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                end_idx = i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        if (start_idx == -1) {
            list.add(start_idx);
        } else {
            for (int i = start_idx; i < end_idx + 1; i++) {
                list.add(arr[i]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}