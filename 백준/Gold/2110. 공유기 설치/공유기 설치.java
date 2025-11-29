import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);

        int left = 1;
        int right = x[n - 1] - x[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1;
            int curr = x[0];

            for (int i = 1; i < n; i++) {
                if (x[i] - curr >= mid) {
                    cnt++;
                    curr = x[i];
                }
            }

            if (cnt >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(answer);
    }
}
