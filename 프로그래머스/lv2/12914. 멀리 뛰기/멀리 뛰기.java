class Solution {
    public long solution(int n) {
        int[] arr = new int[2001];

        for (int i = 0; i < 2001; i++) {
            if (i < 3) {
                arr[i] = i;
            } else {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
            }
        }
        
        return arr[n];
    }
}