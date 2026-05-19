class Solution {
    public int solution(int[] arr) {
        
        return lcm(arr);
    }
    
    public static int lcm(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int great = gcd(arr[0], arr[1]);
        int least = (arr[0] * arr[1]) / great;

        for (int i = 2; i < arr.length; i++) {
            great = gcd(least, arr[i]);
            least = (least * arr[i]) / great;
        }

        return least;
    }



    public static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}