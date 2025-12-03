import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> adjList;
    static int[] d;
    static StringBuilder sb = new StringBuilder();

    static int maxN;
    static int maxD;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        d = new int[n + 1];
        Arrays.fill(d, -1);

        adjList = new ArrayList<>();

        for (int i = 0 ; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        for (List<Integer> list : adjList) {
            list.sort(Comparator.naturalOrder());
        }

        bfs();

        sb.append(maxN).append(" ").append(maxD).append(" ").append(cnt);
        System.out.println(sb.toString());


    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        d[1] = 0;

        maxN = 1;
        maxD = 0;
        cnt = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int a : adjList.get(temp)) {
                if (d[a] == -1) {
                    queue.add(a);
                    d[a] = d[temp] + 1;

                    if (d[a] > maxD) {
                        maxD = d[a];
                        maxN = a;
                        cnt = 1;
                    }
                    else if (d[a] == maxD) {
                        cnt++;
                        maxN = Math.min(maxN, a);
                    }
                }
            }
        }
    }
}
