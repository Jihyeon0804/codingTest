import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int min = 0;
        int[] answer = {};
        List<Integer> ansArr = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] newArr = Arrays.copyOfRange(arr, queries[i][0], queries[i][1]+1);
            List<Integer> intArr = new ArrayList<>();
            for (int n : newArr) {
                if (n > queries[i][2]) {
                    intArr.add(n);
                }
            }
            
            if (intArr.isEmpty()) {
                min = -1;
                ansArr.add(min);
            } else {
                min = intArr.stream().mapToInt(v -> v).min().orElse(0);
                ansArr.add(min); 
            }
            
        }
        Integer[] intgerArr = ansArr.toArray(new Integer[queries.length]);
        answer = Arrays.stream(intgerArr).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}