import java.util.*;

class Solution {
    public int solution(int[] order) {
    
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;

        for (int box = 1; box <= order.length; box++) {
            if (box == order[idx]) {
                idx++;
            }
            else {
                stack.push(box);
            }

            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            }
        }
        
        return idx;
    }
}