import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] dp;
    public static void main(String[] args) throws IOException {

        // 1로 만들기
        // 나누기 3, 나누기 2, 1빼기 가능

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);

    }
}
