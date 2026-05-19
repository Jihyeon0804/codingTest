import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int k, int[] score) {
        Queue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[score.length];

        if (k <= score.length) {
            for (int i = 0; i < k; i++) {
                pq.add(score[i]);
                result[i] = pq.peek();
            }

            for (int i = k; i < score.length; i++) {
                if (score[i] > pq.peek()) {
                    pq.add(score[i]);
                    pq.poll();
                }
                result[i] = pq.peek();
            }
        } else {
            for (int i = 0; i < score.length; i++) {
                pq.add(score[i]);
                result[i] = pq.peek();
            }
        }
        return result;
    }
}