import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int h = 0;
        int w = 0;

        List<List<String>> list = new ArrayList<>();
        for (String s : routes) {
            List<String> direct = new ArrayList<>();
            direct.add(s.split(" ")[0]);
            direct.add(s.split(" ")[1]);
            list.add(direct);
        }

        // 시작점 찾기
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                h = i;
                w = park[i].indexOf("S");
            }
        }
        
        for (List<String> direction : list) {
            int now_h = h;
            int now_w = w;
            
            if (direction.get(0).equals("N")) {
                boolean check = true;
                for (int i = 0; i < Integer.parseInt(direction.get(1)); i++) {
                    now_h--;
                    if (now_w < 0 || now_h < 0 || now_h >= park.length || now_w >= park[0].length()) {
                        check = false;
                        break;
                    }

                    if (park[now_h].charAt(now_w) == 'X') {
                        check = false;
                        break;
                    }


                }

                if (check) {
                    h = now_h;
                }
            }

            if (direction.get(0).equals("S")) {
                boolean check = true;
                for (int i = 0; i < Integer.parseInt(direction.get(1)); i++) {
                    now_h++;
                    if (now_w < 0 || now_h < 0 || now_h >= park.length || now_w >= park[0].length()) {
                        check = false;
                        break;
                    }

                    if (park[now_h].charAt(now_w) == 'X') {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    h = now_h;
                }
            }

            if (direction.get(0).equals("W")) {
                boolean check = true;
                for (int i = 0; i < Integer.parseInt(direction.get(1)); i++) {
                    now_w--;
                    if (now_w < 0 || now_h < 0 || now_h >= park.length || now_w >= park[0].length()) {
                        check = false;
                        break;
                    }

                    if (park[now_h].charAt(now_w) == 'X') {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    w = now_w;
                }
            }
            
            if (direction.get(0).equals("E")) {
                boolean check = true;
                for (int i = 0; i < Integer.parseInt(direction.get(1)); i++) {
                    now_w++;
                    if (now_w < 0 || now_h < 0 || now_h >= park.length || now_w >= park[0].length()) {
                        check = false;
                        break;
                    }

                    if (park[now_h].charAt(now_w) == 'X') {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    w = now_w;
                }
            }
        }
        
        answer[0] = h;
        answer[1] = w;
        return answer;
    }
}