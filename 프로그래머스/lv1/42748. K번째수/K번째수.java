import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < commands.length; i++) {
			int[] ans = {};
			ans = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(ans);
			arr.add(ans[commands[i][2] - 1]);
		}
		answer = arr.stream().mapToInt(i->i).toArray();
		return answer;
    }
}