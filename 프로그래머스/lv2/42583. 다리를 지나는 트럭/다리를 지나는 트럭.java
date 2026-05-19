import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w_sum = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for (int truck_w : truck_weights) {
            while (true) {
                if (que.isEmpty()) {
                    que.offer(truck_w);
                    w_sum += truck_w;
                    answer++;
                    break;
                    
                } else if (que.size() == bridge_length) {
                    w_sum -= que.poll();
                    
                } else {
                    if (w_sum + truck_w <= weight) {
                        que.offer(truck_w);
                        w_sum += truck_w;
                        answer++;
                        break;
                        
                    } else {
                        que.offer(0);
                        answer++;
                    }
                }

            }
        }
        
        return answer + bridge_length;
    }
}