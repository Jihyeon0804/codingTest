class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        if (arr1.length > arr2.length) {
            return 1;
        } else if (arr1.length < arr2.length) {
            return -1;
        } else {
            int sum1 = 0;
            int sum2 = 0;
            for (int n1 : arr1) {
                sum1 += n1;
            }
            for (int n2 : arr2) {
                sum2 += n2;
            }
            return sum1 > sum2 ? 1 : sum1 == sum2 ? 0 : -1;
        }
        
    }
}