class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long totalSum = 0;
        int len = queue1.length;


        for (int i = 0; i < len; i++) {
            sum1 += queue1[i];
            totalSum += queue1[i] + queue2[i];
        }

        if (totalSum % 2 == 1) {
            return -1;
        }

        long target = totalSum / 2;

        int left = 0;
        int right = len;
        int maxCount = len * 4;

        while (answer <= maxCount) {
            if (sum1 == target) {
                return answer;
            }

            if (sum1 > target) {
                int idx = left % (len * 2);
                int val = idx < len ? queue1[idx] : queue2[idx - len];
                sum1 -= val;
                left++;
            } else {
                int idx = right % (len * 2);
                int val = idx < len ? queue1[idx] : queue2[idx - len];
                sum1 += val;
                right++;
            }
            answer++;
        }

        return -1;
    }
}