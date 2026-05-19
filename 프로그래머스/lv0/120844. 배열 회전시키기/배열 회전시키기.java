class Solution {
    public int[] solution(int[] numbers, String direction) {
        if (direction.equals("right")) {
            for (int i = 0; i < numbers.length - 1; i++) {
                int temp = numbers[i];
                numbers[i] = numbers[numbers.length - 1];
                numbers[numbers.length - 1] = temp;
            }
        } else {
            for (int i = 0; i < numbers.length - 1; i++) {
                int temp = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = temp;
            }
        }
        return numbers;
    }
}