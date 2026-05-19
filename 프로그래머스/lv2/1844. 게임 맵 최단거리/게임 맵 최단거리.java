import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int curr_x = curr[0];
            int curr_y = curr[1];

            if (curr_x == maps.length - 1 && curr_y == maps[0].length - 1) {
                return maps[maps.length - 1][maps[0].length - 1];
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr_x + dx[i];
                int ny = curr_y + dy[i];

                if (nx >=0 && nx < maps.length && ny >= 0
                    && ny < maps[0].length && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[curr_x][curr_y] + 1;
                    pq.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}