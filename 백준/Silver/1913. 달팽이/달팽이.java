import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        // S -> E -> N -> W
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int curr = n * n;
        int x, y, d;
        int answerX = 0, answerY = 0;

        x = n % 2 == 0 ? n - 1 : 0;
        y = n % 2 == 0 ? n - 1 : 0;
        d = n % 2 == 0 ? 2 : 0;

        while (curr > 0) {
            if (x >= 0 && y >= 0 && x < n && y < n && arr[x][y] == 0) {
                if (curr == m) {
                    answerX = x + 1;
                    answerY = y + 1;
                }
                arr[x][y] = curr--;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            x = nx;
            y = ny;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(answerX).append(" ").append(answerY);
        System.out.println(sb);
    }
}
