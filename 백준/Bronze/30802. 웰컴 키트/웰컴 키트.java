import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> sizeList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            sizeList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int[] tp = new int[2];
        for (int i = 0; i < tp.length; i++) {
            tp[i] = Integer.parseInt(st.nextToken());
        }

        int t = 0;
        for (int i : sizeList) {
            if (i == 0) {
                continue;
            }

            t += (i / tp[0]);

            if (i % tp[0] > 0) {
                t++;
            }
        }

        sb.append(t).append("\n");
        sb.append(n / tp[1]).append(" ").append(n % tp[1]);

        System.out.println(sb);

    }
}
