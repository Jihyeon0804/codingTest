class Solution {
    public int[] solution(String myString) {
        
        String[] arr = myString.split("x", -1);
        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s : arr) {
            answer[idx++] = s.length();
        }
        return answer;
    }
}