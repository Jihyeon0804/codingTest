import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int mul1 = numbers[0] * numbers[1];
        int mul2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        
        return mul1 > mul2 ? mul1 : mul2;
    }
}