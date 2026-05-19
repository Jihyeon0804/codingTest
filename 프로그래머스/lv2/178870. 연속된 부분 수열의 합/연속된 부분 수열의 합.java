import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> list = new ArrayList<>();
        int s = 0;
        int e = 0;
        int total1 = sequence[s];
        while (s < sequence.length) {
            if (total1 == k) {
                list.add(new int[]{s, e});
                total1 -= sequence[s];
                s++;
            } else if (total1 < k) {
                e++;
                if (e == sequence.length) break;
                total1 += sequence[e];
            } else { // total1 > k
                total1 -= sequence[s];
                s++;
            }
        }

        list.sort((o1, o2) -> {
            int diff1 = o1[1] - o1[0];
            int diff2 = o2[1] - o2[0];

            if (diff1 != diff2) {
                return Integer.compare(diff1, diff2); // 차이 오름차순
            } else {
                return Integer.compare(o1[0], o2[0]);   // 같으면 int[0] 기준 오름차순
            }
        });
        return list.get(0);
    }
}