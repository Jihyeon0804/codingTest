class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            
            if (numbers[i] % 2 == 0) {           // 짝수인 경우
                answer[i] = numbers[i] + 1;
            } else {                            // 홀수인 경우
                long findZero = (~numbers[i]) & numbers[i] + 1;
                answer[i] = (numbers[i] | findZero) & ~(findZero >> 1);
            }
        }
        
        return answer;
    }
}