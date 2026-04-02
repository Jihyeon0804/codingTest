import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] buildTime = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                buildTime[j] = Integer.parseInt(st.nextToken());
            }


            List<List<Integer>> graph = new ArrayList<>();

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            int[] inDegree = new int[n + 1];
            int[][] edges = new int [k][2];

            for (int j = 0; j < k; j++) {
                String[] arr2 = br.readLine().split(" ");
                edges[j][0] = Integer.parseInt(arr2[0]);
                edges[j][1] = Integer.parseInt(arr2[1]);
            }

            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                graph.get(from).add(to);
                inDegree[to]++;
            }

            int w = Integer.parseInt(br.readLine());

            topologicalSort(n, graph, inDegree, buildTime, w);
        }

    }

    public static void topologicalSort(int v, List<List<Integer>> graph, int[] inDegree, int[] buildTime, int w) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] resultTime = new int[v + 1];


        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                resultTime[i] = buildTime[i];
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int next : graph.get(curr)) {
                resultTime[next] = Math.max(resultTime[next], resultTime[curr] + buildTime[next]);
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(resultTime[w]);

    }
}
