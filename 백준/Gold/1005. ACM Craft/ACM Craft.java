import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

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

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                inDegree[to]++;
            }

            int w = Integer.parseInt(br.readLine());

            sb.append(topologicalSort(n, graph, inDegree, buildTime, w)).append("\n");
        }

        System.out.print(sb);

    }

    public static int topologicalSort(int v, List<List<Integer>> graph, int[] inDegree, int[] buildTime, int w) {
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

            if (curr == w) {
                return resultTime[w];
            }

            for (int next : graph.get(curr)) {
                resultTime[next] = Math.max(resultTime[next], resultTime[curr] + buildTime[next]);
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return resultTime[w];

    }
}
