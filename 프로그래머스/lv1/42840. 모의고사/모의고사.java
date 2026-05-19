import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[][] score = {{1, 2, 3, 4, 5},
                         {2, 1, 2, 3, 2, 4, 2, 5},
                         {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        int point;
        int idx = 0;
        for (int[] s : score) {
            point = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == s[i%s.length]) {
                    point++;
                }
            }
            answer[idx++] = point;
        }
        
        
        int max = 0;
        for (int i : answer) {
            max = Math.max(max, i);
        }
        
        
        List<Integer> rank = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == max) {
                rank.add(i + 1);
            }
        }
        
        Collections.sort(rank);
        return rank.stream().mapToInt(i -> i).toArray();
    }
}