import java.util.*;

class Solution {
    public int solution(String numbers) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        int[] arr = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();

        // 순열 구하기
        for (int i = 1; i <= arr.length; i++) {
            permutation(new StringBuilder(), visited, arr, arr.length, i, set);
        }

        // 소수 찾기
        for (int s : set) {
            if (isPrime(s)) {
                list.add(s);
            }
        }
        
        return list.size();
    }
    
    // 소수 찾기 메서드
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 순열 메서드
    static void permutation(StringBuilder str, boolean[] visited, int[] arr, int n, int r, Set<Integer> set) {
        if (str.length() == r) {
            set.add(Integer.parseInt(String.valueOf(str)));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(arr[i]);
                permutation(str.append(arr[i]), visited, arr, n, r, set);
                visited[i] = false;
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}