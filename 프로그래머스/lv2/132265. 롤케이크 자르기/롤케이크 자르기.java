import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        Map<Integer, Integer> preMap = new HashMap<>();
        Set<Integer> postSet = new HashSet<>();

        for (int t : topping) {
            preMap.put(t, preMap.getOrDefault(t, 0) + 1);
        }


        for (int n : topping) {
            postSet.add(n);
            preMap.put(n, preMap.get(n) - 1);

            if (preMap.get(n) == 0) {
                preMap.remove(n);
            }

            if (postSet.size() == preMap.size()) {
                answer++;
            }
        }
        return answer;
    }
}
