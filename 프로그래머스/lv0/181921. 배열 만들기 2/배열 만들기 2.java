import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            String str = "" + i;
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0' || str.charAt(j) == '5') {
                    cnt++;
                }
                
                if (cnt == str.length()) {
                    list.add(i);
                }
            }
   
        }
        if (list.isEmpty()) {
            list.add(-1);
        }
        Integer[] integerArr = list.toArray(new Integer[list.size()]);
        int[] answer = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}