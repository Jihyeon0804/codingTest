import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        Arrays.sort(bill);
        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
            Arrays.sort(bill);
        }
        
        return answer;
    }
}