import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        for (int i = 0; i < mats.length / 2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length - 1 - i];
            mats[mats.length - 1 - i] = temp;
        }

        for (int mat : mats) {
            for (int i = 0; i <= park.length - mat; i++) {
                for (int j = 0; j <= park[0].length - mat; j++) {
                    boolean possible = true;

                    for (int x = 0; x < mat; x++) {
                        for (int y = 0; y < mat; y++) {
                            if (!park[i + x][j + y].equals("-1")) {
                                possible = false;
                                break;
                            }
                        }
                        if (!possible) break;
                    }

                    if (possible) return mat;
                }
            }
        }

        return -1;
    }
}