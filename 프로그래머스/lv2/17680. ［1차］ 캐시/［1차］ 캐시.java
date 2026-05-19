import java.util.Iterator;
import java.util.LinkedHashMap;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        int answer = 0;
        
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>(cacheSize, 0.75f, true);

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();

            // cache size remains
            if (lhm.size() < cacheSize) {
                if (lhm.containsKey(cities[i])) {
                    answer++;
                    lhm.put(cities[i], 0);
                } else {
                    answer += 5;
                    lhm.put(cities[i], 0);
                }
            } else {
                if (lhm.containsKey(cities[i])) {
                    answer++;
                    lhm.put(cities[i], 0);
                } else {
                    answer += 5;
                    Iterator<String> iterator = lhm.keySet().iterator();
                    if (iterator.hasNext()) {
                        String eldestKey = iterator.next();
                        lhm.remove(eldestKey);
                    }
                    lhm.put(cities[i], 0);
                }
            }

        }
        return answer;
    }
}