import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];
        int[][] edges = new int[m][2];


        for (int i = 0; i < m; i++) {
            String[] arr2 = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(arr2[0]);
            edges[i][1] = Integer.parseInt(arr2[1]);
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        topologicalSort(n, graph, inDegree);
    }

    public static void topologicalSort(int v, List<List<Integer>> graph, int[] inDegree) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()) {
            int curr = pq.poll();
            result.add(curr);

            for (int next : graph.get(curr)) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    pq.offer(next);
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
