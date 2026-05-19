import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] win = new boolean[n + 1][n + 1];

        for (int[] edge : results) {
            int winner = edge[0];
            int loser = edge[1];
            win[winner][loser] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }

                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) continue; // 자기 자신은 제외

                if (win[i][j] || win[j][i]) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }
}