import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int n = Integer.parseInt(arr[0]);           // 학생 수 = 노드의 개수
        int m = Integer.parseInt(arr[1]);           // 비교 횟수 = 간선의 개수


        // 연결 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 진입차수 배열 초기화
        int[] inDegree = new int [n + 1];
        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            String[] arr2 = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(arr2[0]);
            edges[i][1] = Integer.parseInt(arr2[1]);
        }

//        System.out.println(Arrays.deepToString(edge));

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        topologicalSort(n, graph, inDegree);
    }

    public static void topologicalSort(int v, List<List<Integer>> graph, int[] inDegree) {

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 처음 시작할 때 진입차수가 0인 노드 큐에 넣기
        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            // 해당 노드와 연결된 노드들의 진입차수 -1
            for (int next : graph.get(curr)) {
                inDegree[next]--;

                // 감소 후 진입차수가 0인 노드를 큐에 삽입
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (result.size() != v) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        
        for (int node : result) {
            sb.append(node).append(" ");
        }

        System.out.println(sb);
    }
}