class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long totalSum = 0;


        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            totalSum += queue1[i] + queue2[i];
        }

        if (totalSum % 2 == 1) {
            return -1;
        }

        long target = totalSum / 2;

        int left = 0;
        int right = queue1.length;
        int maxCount = (queue1.length + queue2.length) * 2;

        while (answer <= maxCount) {
            if (sum1 == target) {
                return answer;
            }

            if (sum1 > target) {
                int idx = left % (queue1.length * 2);
                int val = idx < queue1.length ? queue1[idx] : queue2[idx - queue1.length];
                sum1 -= val;
                left++;
            } else {
                int idx = right % (queue1.length * 2);
                int val = idx < queue1.length ? queue1[idx] : queue2[idx - queue1.length];
                sum1 += val;
                right++;
            }
            answer++;
        }

        return -1;
    }
}