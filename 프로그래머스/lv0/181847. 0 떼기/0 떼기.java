class Solution {
    public String solution(String n_str) {
        int idx = 0;
        StringBuilder sb = new StringBuilder(n_str);
        for (int i = 0; i < n_str.length(); i++) {
            if (sb.charAt(i) != '0') {
                idx = i;
                break;
            }
        }
        return sb.substring(idx, n_str.length());
    }
}