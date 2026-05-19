class Solution {
    public int solution(String dirs) {
        
        String[] arr = dirs.split("");
        boolean[][][] visited = new boolean[11][11][4];
        
        return visitedLength(arr, 5, 5, visited);
    }
    
    public static int visitedLength(String[] arr, int x, int y, boolean[][][] visited) {
        int answer = 0;

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        for (String s : arr) {
            int idx = 0;
            switch (s) {
                case "U" -> idx = 0;
                case "R" -> idx = 1;
                case "L" -> idx = 2;
                case "D" -> idx = 3;
                default -> {
                }
            }

            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx >= 0 && nx <= 10 && ny >= 0 && ny <= 10) {
                if (!visited[nx][ny][3 - idx] && !visited[x][y][idx]) {
                    visited[nx][ny][3 - idx] = true;
                    visited[x][y][idx] = true;
                    answer++;
                }
                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}