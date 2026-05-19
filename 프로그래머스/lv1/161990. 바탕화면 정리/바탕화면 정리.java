class Solution {
    public int[] solution(String[] wallpaper) {
        int min_x = 51;
        int min_y = 51;
        int max_x = -1;
        int max_y = -1;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                
                if (wallpaper[i].charAt(j) == '#') {
                    
                    min_x = Math.min(i, min_x);
                    min_y = Math.min(j, min_y);
                    max_x = Math.max(i, max_x);;
                    max_y = Math.max(j, max_y);;
                }
            }
        }

        int[] answer = {min_x, min_y, max_x + 1, max_y + 1};
        
        return answer;
    }
}