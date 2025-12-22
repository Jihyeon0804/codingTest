import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            sum += m;
            arr[i] = m;
            map.put(m, map.getOrDefault(m, 0) + 1);
        }

        Arrays.sort(arr);

        int max = Collections.max(map.values());
        List<Integer> list = map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(max))
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        int mean = Math.toIntExact(Math.round((double) sum / n));
        int mid = arr[n / 2];
        int mode = list.size() > 1 ? list.get(1) : list.get(0);
        int range = arr[n - 1] - arr[0];

        sb.append(mean).append("\n");       // 산술 평균
        sb.append(mid).append("\n");        // 중앙값
        sb.append(mode).append("\n");        // 최빈값
        sb.append(range).append("\n");      // 범위

        System.out.println(sb);
    }
}
