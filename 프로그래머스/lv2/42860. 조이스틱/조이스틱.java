class Solution {
    public int solution(String name) {
        
        int cnt1 = 0;
        int cnt2 = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            cnt1 +=  Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        for (int i = 0; i < name.length(); i++) {

            int idx = i + 1;

            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }

            int case1 = i + (name.length() - idx) * 2;
            int case2 = (i * 2) + name.length() - idx;

            cnt2 = Math.min(cnt2, Math.min(case1, case2));
        }

        return cnt1 + cnt2;
    }
}