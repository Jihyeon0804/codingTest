import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k);
        
        return answer;
    }
    
    static void dfs(int[][] dungeons, int cnt, int k) {

        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            int min = dungeons[i][0];
            int consume = dungeons[i][1];

            if (visited[i] || k < min) {
                continue;
            }

            visited[i] = true;
            dfs(dungeons, cnt + 1, k - consume);
            visited[i] = false;
        }
    }
}