import java.util.Arrays;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = generatePartialMatrix(n, left, (int) (right - left + 1));
        
        return answer;
    }
    
    public static int[] generatePartialMatrix(int n, long startIndex, int count) {
        int[] result = new int[count]; // 결과 저장용 배열

        for (int k = 0; k < count; k++) {
            long index = startIndex + k; // 현재 1차원 인덱스
            long row = index / n;        // 행 계산
            long col = index % n;        // 열 계산

            result[k] = (int) (Math.max(row, col) + 1); // 값 계산
        }

        return result;
    }
}