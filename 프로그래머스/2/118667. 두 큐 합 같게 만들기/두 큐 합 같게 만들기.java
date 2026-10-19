import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long que1Sum = 0;
        long que2Sum = 0;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            que1.offer(queue1[i]);
            que1Sum += queue1[i];

            que2.offer(queue2[i]);
            que2Sum += queue2[i];
        }

        long target = (que1Sum + que2Sum) / 2;

        // 합이 홀수인 경우는 불가능
        if ((que1Sum + que2Sum) % 2 == 1) {
            return -1;
        }
        int maxCount = (queue1.length + queue2.length) * 2;

        while (answer < maxCount) {

            if (que1Sum == target && que2Sum == target) {
                return answer;
            }
            int num;
            if (que1Sum > target) {
                num = que1.poll();
                que1Sum -= num;
                que2.offer(num);
                que2Sum += num;

            } else if (que2Sum > target) {
                num = que2.poll();
                que2Sum -= num;
                que1.offer(num);
                que1Sum += num;
            }
            answer++;

        }
        
        return -1;
    }
}