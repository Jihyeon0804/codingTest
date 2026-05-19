import java.util.*; 

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> batchList = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            batchList.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
       
        List<Integer> list = new ArrayList<>();
        
        int max = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
        int cnt = 0;
        for (int i = 0; i < batchList.size(); i++) {
            if (max >= batchList.get(i)) {
                cnt++;
                
            } else {
                list.add(cnt);
                max = batchList.get(i);
                cnt = 0;
                cnt++;
            }
        }
        list.add(cnt);
        return list.stream().mapToInt(i -> i).toArray();
    }
}