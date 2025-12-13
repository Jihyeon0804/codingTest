class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        return getMaxDungeons(dungeons, k);
    }
    
    static int getMaxDungeons(int[][] dungeons, int k) {
        boolean[] visited = new boolean[dungeons.length];
        exploreDungeon(dungeons, k, 0, visited);
        return answer;
    }

    static void exploreDungeon(int[][] dungeons, int k, int count, boolean[] visited) {
        // 최대 던전 탐험 수 갱신
        answer = Math.max(answer, count);

        // 모든 모험을 탐색
        for (int i = 0; i < dungeons.length; i++) {
            int minimum = dungeons[i][0];
            int consume = dungeons[i][1];

            // 이미 탐험한 던전 이거나 체력이 부족하면 패스
            if (visited[i] || k < minimum)
                continue;

            // 던전 탐험
            visited[i] = true;
            exploreDungeon(dungeons, k - consume, count + 1, visited);
            visited[i] = false; // 탐색 후 돌려놓기
        }
    }
}