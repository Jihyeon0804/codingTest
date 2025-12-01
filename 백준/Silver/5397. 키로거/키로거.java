import java.io.*;

public class Main {
    static final int MAX = 1000001;
    static int[] pre = new int[MAX];
    static int[] post = new int[MAX];
    static char[] data = new char[MAX];
    static int unused = 1;
    static int cursor = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            getPassword(s);

            int add = post[0];
            while (add != -1) {
                sb.append(data[add]);
                add = post[add];
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void getPassword(String s) {
        
        unused = 1;
        cursor = 0;
        post[0] = -1;
        pre[0] = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                if (pre[cursor] != -1) {
                    cursor = pre[cursor];
                }
            } else if (c == '>') {
                if (post[cursor] != -1) {
                    cursor = post[cursor];
                }
            } else if (c == '-') {
                if (cursor != 0) {
                    erase();
                }
            } else {
                insert(c);
            }
        }
    }

    static void insert(char c) {
        data[unused] = c;
        pre[unused] = cursor;
        post[unused] = post[cursor];

        if (post[cursor] != -1) {
            pre[post[cursor]] = unused;
        }

        post[cursor] = unused;

        cursor = unused;
        unused++;
    }
    
    static void erase() {
        if (post[cursor] != -1) {
            pre[post[cursor]] = pre[cursor];
        }
        
        post[pre[cursor]] = post[cursor];

        cursor = pre[cursor];
    }
}
