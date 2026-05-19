class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
		String answer = "";
		int temp = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (temp > Integer.valueOf(arr[i])) {
				temp = Integer.valueOf(arr[i]);
			}
		}
		answer = answer + temp;
		
		// 최댓값 구하기
		temp = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (temp < Integer.valueOf(arr[i])) {
				temp = Integer.valueOf(arr[i]);
			}
		}
		answer = answer + " " + temp;
        return answer;
    }
}