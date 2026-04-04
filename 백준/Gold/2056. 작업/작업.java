import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] buildTime = new int[n + 1];
        int[] inDegree = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            if (cnt != 0) {
                for (int j = 0; j < cnt; j++) {
                    int to = Integer.parseInt(st.nextToken());
                    graph.get(i).add(to);
                    inDegree[to]++;
                }
            }

        }

        topologicalSort(n, graph, inDegree, buildTime);
    }

    public static void topologicalSort(int n, List<List<Integer>> graph, int[] inDegree, int[] buildTime) {
        int[] resultTime = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                resultTime[i] = buildTime[i];
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                resultTime[next] = Math.max(resultTime[next], resultTime[curr] + buildTime[next]);
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        int result = 0;
        for (int r : resultTime) {
            result = Math.max(result, r);
        }
        System.out.println(result);
    }
}
