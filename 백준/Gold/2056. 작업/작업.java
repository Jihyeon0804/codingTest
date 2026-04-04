import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int totalTime = 0;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            int buildTime = 0;
            for (int j = 0; j < cnt; j++) {
                int next = Integer.parseInt(st.nextToken());
                buildTime = Math.max(buildTime, dp[next]);
            }

            dp[i] = buildTime + time;

            totalTime = Math.max(totalTime, dp[i]);
        }
        
        System.out.println(totalTime);
    }
}
