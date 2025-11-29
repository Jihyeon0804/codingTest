import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 10000;

        int left = Arrays.stream(arr).max().orElse(0);
        int right = Arrays.stream(arr).sum();

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (cnt > c) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }

        }

        System.out.println(answer);

    }
}
