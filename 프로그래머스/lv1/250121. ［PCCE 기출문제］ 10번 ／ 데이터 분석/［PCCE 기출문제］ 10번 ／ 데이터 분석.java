import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int []> answer = new ArrayList<>();
		
		Map<String, Integer> data_lst = new HashMap<>();
		data_lst.put("code", 0);
		data_lst.put("date", 1);
		data_lst.put("maximum", 2);
		data_lst.put("remain", 3);
		
		for (int i = 0; i < data.length; i++) {
			if (data[i][data_lst.get(ext)] < val_ext) {
				answer.add(data[i]);
			}
		}
        
        answer.sort(Comparator.comparingInt(o -> o[data_lst.get(sort_by)]));
        
        return answer.toArray(new int[0][]);
    }
}