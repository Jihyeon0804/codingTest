import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int n = Integer.parseInt(arr[0]); // 학생 수
        int m = Integer.parseInt(arr[1]); // 비교 횟수

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] arr2 = br.readLine().split(" ");
            int from = Integer.parseInt(arr2[0]);
            int to = Integer.parseInt(arr2[1]);
            graph.get(from).add(to);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }

    // DFS
    public static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문 처리

        // 현재 노드와 연결된 다음 노드들을 탐색
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }

        stack.push(node);
    }
}