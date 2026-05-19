import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 중괄호 제거 후 배열에 담기
        s = s.replaceAll("[{}]", "");
        String[] nums = s.split(",");

        // 원소의 개수
        Map<Integer, Integer> map = new HashMap<>();
        for (String num : nums) {
            int n = Integer.parseInt(num);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 내림차순 정렬 후 배열로 변환
        return map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
