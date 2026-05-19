import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        while (queue.peek() < K) {

            if (queue.size() >= 2) {
                int min1 = queue.poll();
                int min2 = queue.poll();
                queue.add(min1 + min2 * 2);
                answer++;
            } else {
                return -1;
            }  
        }
        return answer;
    }
}