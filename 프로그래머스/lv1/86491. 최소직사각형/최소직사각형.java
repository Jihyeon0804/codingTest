import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        int answer = 0;
//         int temp;
//         for (int[] size : sizes) {
//             if (size[0] > size[1]) {
//                 temp = size[0];
//                 size[0] = size[1];
//                 size[1] = temp;
//             }
//         }
        
//        for (int i = 0; i < sizes.length; i++) {
//            if (sizes[i][0] > width) {
//                width = sizes[i][0];
//            }
//         }
        
//         for (int i = 0; i < sizes.length; i++) {
//            if (sizes[i][1] > height) {
//                height = sizes[i][1];
//            }
//         }
        
        for (int[] size : sizes) {
            // 큰 것 중에 가장 큰 수
            width = Math.max(width, Math.max(size[0], size[1]));
            // 작은 것 중에 가장 큰 수
            height = Math.max(height, Math.min(size[0], size[1]));
        }
        
        answer = width * height;
        return answer;
    }
}