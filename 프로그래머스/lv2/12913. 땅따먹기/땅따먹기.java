import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {

                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(max, land[i-1][k]);
                    }
                }
                land[i][j] += max;
            }
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}