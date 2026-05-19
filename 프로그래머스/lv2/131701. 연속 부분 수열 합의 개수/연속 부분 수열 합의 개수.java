import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int[] sum = new int[elements.length];

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0 ; j < elements.length; j++) {
                sum[j] += elements[(i+j-1)%elements.length];
                set.add(sum[j]);
            }
        }
        return set.size();
    }
}