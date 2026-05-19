class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int idx = 0;
        for (int[] arr : answer) {
          arr[idx++] = 1;  
        }
        return answer;
    }
}