class Solution {
    public int solution(int[] num_list) {
        String str1 = "";
        String str2 = "";
        for (int num : num_list) {
            if (num % 2 == 0) {
                str1 += num;
            } else {
                str2 += num;
            }
        }
        return Integer.parseInt(str1) + Integer.parseInt(str2) ;
    }
}