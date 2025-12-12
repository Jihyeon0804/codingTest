import java.util.*;

class Solution {
    
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] land) {
        
        int[][] visited = new int[land.length][land[0].length];
        Map<Integer, Integer> map = new HashMap<>();
	       
	      int idx = 1;
	      
        for (int i = 0; i < land.length; i++) {
		        for (int j = 0; j < land[0].length; j++) {
				        if (land[i][j] == 1 && visited[i][j] == 0) {
						        int cnt = bfs(land, visited, i, j, idx);
						        map.put(idx, cnt);
                    idx++;
				        }
		        }
	        
        }

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

            max = Math.max(max, sum);
        }

        return max;
    }
    
    static int bfs(int[][] land, int[][] visited,
                    int x, int y, int idx) {

        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = idx;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curr_x = curr[0];
            int curr_y = curr[1];
            for (int z = 0; z < 4; z++) {
                int nx = curr_x + dx[z];
                int ny = curr_y + dy[z];

                if (nx >= 0 && nx < land.length
                        && ny >= 0 && ny < land[0].length
                        && land[nx][ny] == 1
                        && visited[nx][ny] == 0) {

                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = idx;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}