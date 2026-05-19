import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        //List<Integer> answer = new ArrayList<>();
        int[] answer = new int[prices.length];
        Queue<Integer> que = new LinkedList<>();
        
        for (int p : prices) {
            que.offer(p);
        }
        int idx = 0;
        while(!que.isEmpty()) {
            int time = 0;
            
            int num = que.poll();

            for (Integer q : que) {
                
                if (num <= q) {
                    time++;
                } else {
                    time++;
                    break;
                }
            }
            answer[idx++] = time;
        }
        //return answer.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}