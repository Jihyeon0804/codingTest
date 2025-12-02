import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        long cnt = 0;

        int i = 0;
        long sum = 0;

       for (int j = 0; j < n; j++) {

           sum += arr[j];

           while (sum > k) {
               cnt += n - j;
               sum -= arr[i++];
           }
       }

        System.out.println(cnt);
    }
}
