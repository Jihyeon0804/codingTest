class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ", -1);
        for (String st : arr) {
            if (st.length() == 0) {
                sb.append(" ");
            } else {
                sb.append(st.substring(0, 1).toUpperCase());
                sb.append(st.substring(1));
                sb.append(" ");
            }
        }

        return sb.substring(0, sb.length() - 1);
    }
}