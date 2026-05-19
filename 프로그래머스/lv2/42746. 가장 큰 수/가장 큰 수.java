import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();

        int idx = 1;
        while (idx <= numbers.length) {
            StringBuilder num = new StringBuilder();
            
            for (int i = 0; i < numbers.length; i++) {
                num.append(numbers[(idx + i - 1) % numbers.length]);
            }
            
            list.add(String.valueOf(num));
            idx++;
        }

        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}