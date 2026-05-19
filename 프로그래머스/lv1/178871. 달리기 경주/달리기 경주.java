import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
       
        Map<String, Integer> map = new HashMap<>();
        int rank = 0;
        for (String p : players) {
            map.put(p, rank++);
        }

        for (String call : callings) {
            int value = map.get(call);
            String temp = players[value - 1];
            players[value] = temp;
            players[value - 1] = call;

            map.put(temp, value);
            map.put(call, value - 1);
        }

        
        return players;
    }
}