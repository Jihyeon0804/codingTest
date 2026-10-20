class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        dfs(arr, answer, 0, 0, arr.length);
        
        return answer;
    }

    static void dfs(int[][] arr, int[] answer, int row, int col, int size) {
        int init = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != init) {
                    dfs(arr, answer, row, col, size / 2);
                    dfs(arr, answer, row + size / 2, col, size / 2);
                    dfs(arr, answer, row, col + size / 2, size / 2);
                    dfs(arr, answer, row + size / 2, col + size / 2, size / 2);
                    return;
                }
            }
        }
        answer[init]++;
    }
}