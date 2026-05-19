class Solution {
    public String[] solution(String my_string) {
        
        // my_string = my_string.trim().replaceAll("\\s+", " ");
        my_string = my_string.trim();
        while (my_string.contains("  ")) {
            my_string = my_string.replace("  ", " ");
        }
        String[] answer = my_string.split(" ");
        return answer;
    }
}