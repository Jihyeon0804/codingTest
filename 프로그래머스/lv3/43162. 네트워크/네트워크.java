import java.util.*;

class Solution {
    
    static List<List<Integer>> adjust = new ArrayList<>();
    static boolean[] visited;
    static int cnt;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        cnt = 0;

        for (int i = 0; i < n; i++) {
            adjust.add(new ArrayList<>());
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    adjust.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        
        return cnt;
    }
    
    static void dfs(int idx) {
        visited[idx] = true;

        for (int nx : adjust.get(idx)) {
            if (!visited[nx]) {
                dfs(nx);
            }
        }
    }
}