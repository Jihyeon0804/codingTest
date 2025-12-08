import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int idx = 1;
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                // map 생성
                int[][] map = new int[n][n];
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < n; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                int[][] dist = new int[n][n];
                for (int[] d : dist) {
                    Arrays.fill(d, Integer.MAX_VALUE);
                }
                dist[0][0] = map[0][0];

                // 최단 경로 로직
                PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
                pq.offer(new int[]{0, 0, dist[0][0]});

                while (!pq.isEmpty()) {
                    int[] curr = pq.poll();
                    int x = curr[1];
                    int y = curr[0];
                    int weight = curr[2];

                    if (dist[y][x] < weight) {
                        continue;
                    }

                    for (int i = 0 ; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (dist[y][x] + map[ny][nx] < dist[ny][nx]) {
                                dist[ny][nx] = dist[y][x] + map[ny][nx];
                                pq.offer(new int[]{ny, nx, dist[ny][nx]});
                            }
                        }
                    }

                }

                String s = String.format("Problem %d: %d", idx++, dist[n - 1][n - 1]);
                sb.append(s).append("\n");
            }
        }

        System.out.println(sb);
    }
}
