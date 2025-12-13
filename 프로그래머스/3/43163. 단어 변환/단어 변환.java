import java.util.*;

class Solution {
    
    static boolean[] visited;

    static class Word {
        String word;
        int cnt;

        public Word(String begin, int cnt) {
            this.word = begin;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        return bfs(words, begin, target);
    }
    
    static int bfs(String[] words, String begin, String target) {

        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word word = queue.poll();
            String w = word.word;
            int cnt = word.cnt;

            if (w.equals(target)) {
                return cnt;
            } else {
                for (int i = 0 ; i < words.length; i++) {
                    if (checkWord(words[i], w) && !visited[i]) {
                        visited[i] = true;
                        queue.offer(new Word(words[i], cnt + 1));
                    }
                }
            }


        }

        return 0;
    }

    static boolean checkWord(String s1, String s2) {

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}