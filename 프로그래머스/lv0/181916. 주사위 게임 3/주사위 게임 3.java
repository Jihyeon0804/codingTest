import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        d = arr[3];
        
        if (a == d) { // 4개의 주사위가 모두 같은 수
            return 1111 * a;
            
        } else if ((a != b) && (b == d)) { // 3개가 같은 수 나머지 하나는 다른 수
            return (int) Math.pow((10 * b + a), 2);
            
        } else if ((a == c) && (c != d)) { // 3개가 같은 수 나머지 하나는 다른 수
            return (int) Math.pow((10 * c + d), 2);
            
        } else if ((a == b) && (b != c) && (c != d)) { // 맨 앞 두 개만 같은 수
            return c * d;
            
        } else if ((a != b) && (b == c) && (c != d)) { // 중간 두 개만 같은 수
            return a * d;
            
        } else if ((a != b) && (b != c) && (c == d)) { // 끝에 두 개만 같은 수
            return a * b;
            
        } else if ((a == b) && (b != c) && (c ==d)) { // 두 개씩 같은 수
            return (b + c) * Math.abs(b - c);
            
        } else { // 4개의 숫자가 모두 다른 경우
            return Arrays.stream(arr).min().getAsInt();
        }
    }
}