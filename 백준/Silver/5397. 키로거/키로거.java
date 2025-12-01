import java.io.*;

public class Main {
    static final int MX = 1000005;
    static int[] pre = new int[MX];
    static int[] nxt = new int[MX];
    static char[] dat = new char[MX];
    static int unused = 1;
    static int cursor = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            run(s);
            
            int addr = nxt[0];
            while (addr != -1) {
                sb.append(dat[addr]);
                addr = nxt[addr];
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void run(String s) {
        unused = 1;
        cursor = 0;
        nxt[0] = -1; 
        pre[0] = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                if (pre[cursor] != -1) {
                    cursor = pre[cursor];
                }
            } else if (c == '>') {
                if (nxt[cursor] != -1) {
                    cursor = nxt[cursor];
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
        dat[unused] = c;
        pre[unused] = cursor;
        nxt[unused] = nxt[cursor];

        if (nxt[cursor] != -1) {
            pre[nxt[cursor]] = unused;
        }

        nxt[cursor] = unused;

        cursor = unused;
        unused++;
    }

    static void erase() {
        if (nxt[cursor] != -1) {
            pre[nxt[cursor]] = pre[cursor];
        }
        
        nxt[pre[cursor]] = nxt[cursor];
        
        cursor = pre[cursor];
    }
}