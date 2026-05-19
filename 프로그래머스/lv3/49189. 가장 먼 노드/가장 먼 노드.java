import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        return bfs(n, adjList);
    }
    
    static int bfs(int n, List<List<Integer>> adjList) {
        
        int cnt = 0;

        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        distance[1] = 0;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adjList.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[curr] + 1;
                    queue.add(next);
                }
            }
        }

        int max = 0;

        for (int dist : distance) {
            if (dist > max) {
                max = dist;
            }
        }

        for (int dist : distance) {
            if (dist == max) {
                cnt++;
            }
        }

        return cnt;
    }
}