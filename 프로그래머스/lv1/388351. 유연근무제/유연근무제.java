class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            schedules[i] += 10;
            if (schedules[i] % 100 >= 60) {
                schedules[i] += 40;
            }
        }

        for (int i = 0; i< schedules.length; i++) {
            int cnt = 0;
            for (int j = 0; j < timelogs[i].length; j++) {
                if ((j + startday) % 7 == 6 || (j + startday) % 7 == 0) {
                    cnt++;
                } else if (timelogs[i][j] <= schedules[i]) {
                    cnt++;
                } else {
                    break;
                }

            }

            if (cnt == timelogs[i].length) {
                answer++;
            }
        }
        return answer;
    }
}