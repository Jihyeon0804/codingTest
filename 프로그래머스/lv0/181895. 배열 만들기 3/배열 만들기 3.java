import java.util.*;


class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = new int[intervals[0][1] - intervals[0][0] + intervals[1][1] - intervals[1][0] + 2];
        int cnt = 0;
        
        for (int[] interval : intervals) {
            for (int i = 0; i < arr.length; i++) {
                if (i >= interval[0] && i <= interval[1]) {
                    answer[cnt++] = arr[i];
                }
            }
        }
        
        
        return answer;
    }
}