import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];
           
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int curr = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt - 1; j++) {
                int post = Integer.parseInt(st.nextToken());
                graph.get(curr).add(post);
                inDegree[post]++;

                curr = post;
            }
        }
        

        topologicalSort(n, graph, inDegree);
    }

    public static void topologicalSort(int n, List<List<Integer>> graph, int[] inDegree) {

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int next : graph.get(curr)) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (result.size() != n) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append("\n");
        }
        System.out.println(sb);
    }
}
