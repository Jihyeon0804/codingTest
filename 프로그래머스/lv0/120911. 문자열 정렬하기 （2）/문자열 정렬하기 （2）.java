import java.util.*;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        
        char[] arr = my_string.toCharArray();
        Arrays.sort(arr);
        my_string = new String(arr);
        return my_string;
    }
}