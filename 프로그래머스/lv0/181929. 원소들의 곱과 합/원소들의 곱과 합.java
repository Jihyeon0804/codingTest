import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int sum = 0;
        for (int a : num_list) {
            mul *= a;
            sum += a;
        }
        return mul < Math.pow(sum, 2) ? 1 : 0;
    }
}