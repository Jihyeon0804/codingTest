import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int n, curr_x, curr_y;

    static int cnt, answer = 0;
    static int size = 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    curr_x = i;
                    curr_y = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            if (!bfs()) {
                break;
            }
        }

        System.out.println(answer);
    }

    static boolean bfs() {

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{curr_x, curr_y});
        dist[curr_x][curr_y] = 0;

        int min = Integer.MAX_VALUE;
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (dist[x][y] >= min) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && dist[nx][ny] == -1 && map[nx][ny] <= size) {

                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[]{nx, ny});

                    if (map[nx][ny] != 0 && map[nx][ny] < size) {
                        if (dist[nx][ny] < min) {
                            min = dist[nx][ny];
                            min_x = nx;
                            min_y = ny;
                        }
                        else if (dist[nx][ny] == min) {
                            if (nx < min_x) {
                                min_x = nx;
                                min_y = ny;
                            } else if (nx == min_x) {
                                if (ny < min_y) {
                                    min_y = ny;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (min_x == Integer.MAX_VALUE) {
            return false;
        }

        curr_x = min_x;
        curr_y = min_y;
        answer += min;
        map[curr_x][curr_y] = 0;
        cnt++;

        if (cnt == size) {
            size++;
            cnt = 0;
        }

        return true;
    }

}
