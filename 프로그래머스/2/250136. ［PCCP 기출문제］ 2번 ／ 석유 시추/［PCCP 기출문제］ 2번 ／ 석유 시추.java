import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map = new HashMap<>();
    static int[][] visited;
    static int idx = 1;
    
    public int solution(int[][] land) {
        
        visited = new int[land.length][land[0].length];
        bfs(land);

        int max = 0;
        for (int i = 0; i < land[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] != 0) {
                    set.add(visited[j][i]);
                }
            }
            int sum = 0;
            for (int s : set) {
                sum += map.get(s);
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
    
    static void bfs(int[][] land) {

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {

                if (land[i][j] == 1 && visited[i][j] == 0) {
                    int cnt = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});

                    visited[i][j] = idx;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];
                        for (int z = 0; z < 4; z++) {
                            int nx = x + dx[z];
                            int ny = y + dy[z];

                            if (nx >= 0 && nx < land.length
                                && ny >= 0 && ny < land[0].length
                                && land[nx][ny] == 1 && visited[nx][ny] == 0) {
                                
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = idx;
                                cnt++;
                            }
                        }
                    }
                    map.put(idx, cnt);
                    idx++;
                }

            }
        }
    }
}