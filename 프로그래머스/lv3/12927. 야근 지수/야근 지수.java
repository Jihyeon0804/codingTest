import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long cnt = 0;
        for (int a : works) {
            pq.add(a);
        }
        while (n > 0) {
            pq.add(pq.poll() - 1);
            n--;
        }

        for (int a : pq) {
            if (a > 0) {
                cnt += (long) Math.pow(a, 2);
            }
        }
        return cnt;
    }
}