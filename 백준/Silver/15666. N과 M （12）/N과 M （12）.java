import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        // 자신 포함, 중복X
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> myList = new ArrayList<>(set);
        Collections.sort(myList);

        permu(myList, new ArrayList<>(), m, 0);

        bw.flush();
        bw.close();

    }

    static void permu(List<Integer> myList, List<Integer> list, int target, int start) throws IOException {
        if (list.size() == target) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i < list.size() - 1) sb.append(' ');
            }
            bw.write(sb.toString());
            bw.newLine();
            return;
        }
        for (int i = start; i < myList.size(); i++) {
            list.add(myList.get(i));
            permu(myList, list, target, i);
            list.remove(list.size() - 1);
        }
    }
}
