class Solution {
    public String solution(int age) {
        String answer = "";
        String[] arr = String.valueOf(age).split("");
        for (String s : arr) {
            answer += (char) (Integer.parseInt(s) + 97);
        }
        return answer;
    }
}