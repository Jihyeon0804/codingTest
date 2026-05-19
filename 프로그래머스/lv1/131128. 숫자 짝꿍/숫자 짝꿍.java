import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < X.length(); i++) {
            xArr[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            yArr[Y.charAt(i) - '0']++;
        }

        for (int i = xArr.length - 1; i >= 0; i--) {
            if (xArr[i] > 0 && yArr[i] > 0) {

                if (xArr[i] < yArr[i]) {
                    for (int j = 0; j < xArr[i]; j++) {
                        list.add(i);
                    }
                } else {
                    for (int j = 0; j < yArr[i]; j++) {
                        list.add(i);
                    }
                }
            }
        }

        if (list.isEmpty()) {
            answer.append(-1);
        }

        for (int i : list) {
            answer.append(i);
        }

        if (answer.charAt(0) == '0' && answer.charAt(answer.length() - 1) == '0') {
            return String.valueOf(answer.charAt(0));
        }
        
        return answer.toString();
    }
}