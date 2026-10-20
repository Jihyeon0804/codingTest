class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long que1Sum = 0;
        long arrSum = 0;

        int maxCount = (queue1.length + queue2.length) * 2;

        int[] arr = new int[queue1.length + queue2.length];

        for (int i = 0; i <queue1.length; i++) {
            arr[i] = queue1[i];
            arr[i + queue1.length] = queue2[i];
            que1Sum += queue1[i];
            arrSum += queue1[i] + queue2[i];
        }

        long target = arrSum / 2;
        if (arrSum % 2 == 1) {
            return -1;
        }

        int left = 0;
        int right = queue1.length;

        while (answer <= maxCount) {
            if (que1Sum == target) {
                return answer;
            }
            if (que1Sum > target) {
                que1Sum -= arr[left % arr.length];
                left++;
            } else {
                que1Sum += arr[right % arr.length];
                right++;
            }
            answer++;
        }

        return -1;
    }
}