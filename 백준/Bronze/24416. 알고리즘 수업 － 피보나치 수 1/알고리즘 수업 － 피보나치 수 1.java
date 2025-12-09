import java.io.*;

public class Main {

    static long[] f = new long[41];
    static int sum1 = 1;
    static int sum2 = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        fib(n);
        fibonacci(n);
        sb.append(sum1).append(" ").append(sum2);
        System.out.println(sb);
    }

    static long fib(int n) {
        long l;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            l = fib(n - 1) + fib(n - 2);
            sum1++;
        }
        return l;
    }

    static void fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            sum2++;
        }
    }
}
