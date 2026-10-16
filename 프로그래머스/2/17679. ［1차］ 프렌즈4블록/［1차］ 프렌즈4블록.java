class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] map = new String[m][n];

        // map 초기화
        for (int i = 0; i < m; i++) {
            map[i] = board[i].split("");
        }

        while (true) {
            // 지울 블록 확인하기 위한 2차원 배열
            boolean[][] deleteBlock = new boolean[m][n];
            boolean flag = false;   // 이번 턴에 2*2 블록 존재 여부

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j].equals("X")) {
                        continue;
                    }
                    String curr = map[i][j];
                    // 2*2 완성 블록이면 deletedBlock에 true 표시
                    if (curr.equals(map[i][j + 1]) && curr.equals(map[i + 1][j]) && curr.equals(map[i + 1][j + 1])) {
                        deleteBlock[i][j] = true;
                        deleteBlock[i][j + 1] = true;
                        deleteBlock[i + 1][j] = true;
                        deleteBlock[i + 1][j + 1] = true;
                        flag = true; // 지울 블록이 있음을 표시
                    }
                }
            }

            // 지울 블록이 없으면 pass
            if (!flag) {
                break;
            }

            // 지울 블록 count
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (deleteBlock[i][j]) {
                        answer++;
                        map[i][j] = "X";
                    }
                }
            }

            // 블록이 아래로 떨어뜨려 빈 공간을 채우기
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j].equals("X")) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (!map[k][j].equals("X")) {
                                map[i][j] = map[k][j];
                                map[k][j] = "X";
                                break;
                            }
                        }
                    }
                }
            }

        }

        return answer;
    }
}