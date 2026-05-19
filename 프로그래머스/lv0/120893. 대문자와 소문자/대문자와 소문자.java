class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = my_string.toCharArray();
        for (char ch : cArr) {
            if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}