class Solution {
    public int solution(int n, String control) {
        int i = 0;
        int cnt = control.length();
        char[] controlArr = control.toCharArray();
        while (cnt > 0) {
            switch (controlArr[i]) {
                case 'w':
                    n +=1;
                    break;
                case 's':
                    n -=1;
                    break;
                case 'd':
                    n +=10;
                    break;
                case 'a':
                    n -=10;
                    break;
            }
            cnt--;
            i++;;
        }
        return n;
    }
}