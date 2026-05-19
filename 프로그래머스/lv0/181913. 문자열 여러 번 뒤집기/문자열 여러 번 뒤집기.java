import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] query : queries) {
            StringBuffer sb = new StringBuffer(my_string.substring(query[0], query[1] + 1));
            my_string = my_string.substring(0, query[0]) + sb.reverse().toString() + my_string.substring(query[1] + 1, my_string.length());
        }
        
        return my_string;
    }
}