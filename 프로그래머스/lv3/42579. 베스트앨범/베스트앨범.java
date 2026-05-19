import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 재생횟수
        Map<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (hm.containsKey(genres[i])) {
                hm.put(genres[i], hm.get(genres[i]) + plays[i]);
            } else {
                hm.put(genres[i], plays[i]);
            }
        }
        List<String> keyList = new ArrayList<>(hm.keySet());
        keyList.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));
        System.out.println(hm);
       
        // 장르별 고유번호의 재생횟수
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        for (String s : hm.keySet()) {
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(s)) {
                    m.put(i, plays[i]);
                }
            }
            map.put(s, m);
        }
        System.out.println(map);
        List<Integer> ans = new ArrayList<>();
        for (String s : keyList) {
            List<Integer> list = new ArrayList<>(map.get(s).keySet());
            list.sort((o1, o2) -> map.get(s).get(o2).compareTo(map.get(s).get(o1)));
            
            if (map.get(s).size() < 2) {
                ans.add(list.get(0));
                    
            } else {
                ans.add(list.get(0));
                ans.add(list.get(1));
            }
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}