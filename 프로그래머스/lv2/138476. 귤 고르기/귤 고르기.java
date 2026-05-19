import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        int[] cnt = new int[map.keySet().size()];
        int idx = 0;
        for (int key : map.keySet()) {
            cnt[idx++] = map.get(key);
        }

        Arrays.sort(cnt);
        for (int i = cnt.length - 1; i >= 0; i--) {
            if (k > 0) {
                answer++;
                k -= cnt[i];
            }
        }
        
        return answer;
    }
}