class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");
        int answer = 0;
        switch (arr[1]) {
            case "+":
                answer =  Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
                break;
            case "-":
                answer =  Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
                break;
            case "*":
                answer =  Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
                break;
        }
        return answer;
    }
}