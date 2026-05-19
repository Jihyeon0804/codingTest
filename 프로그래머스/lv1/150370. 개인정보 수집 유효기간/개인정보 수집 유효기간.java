import java.text.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String signUpDate =  privacies[i].split(" ")[0];
            String kind =  privacies[i].split(" ")[1];
            int period = 0;
            for (String term : terms) {
                if (term.split(" ")[0].equals(kind)) {
                    period = Integer.parseInt(term.split(" ")[1]);
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            try {
                Date date = sdf.parse(signUpDate);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.MONTH, period);
                String expiration = sdf.format(calendar.getTime());
                
                if (expiration.compareTo(today) <= 0) {
                    answer.add(i + 1);
                }
            } catch (Exception e) {
                
            }
            
            

            
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}